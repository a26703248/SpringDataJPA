package study.spring.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpSpecificationRepository;

@ContextConfiguration(classes= SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class JpaSpecificationTest {

  @Autowired
  private EmpSpecificationRepository empSpecificationRepository;

  @Autowired
  private EntityManager entityManager;

  // Spring Data JPA
  @Test
  public void selectTest() {
    Emp emp = new Emp();
    emp.setId(5L);
    emp.setName("keven,jason,Hellen");

    // Specification<Emp> Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);
    List<Emp> findAll = empSpecificationRepository.findAll((root, query, cb) -> {
      // Root from Emp 取得欄位
      // CriteriaQuery 組合(order by, where)
      // CriteriaBuilder where 設定條件
      Path<Long> id = root.get("id");
      Path<String> name = root.get("name");


      List<Predicate> list = new ArrayList<>();
      if(StringUtils.isEmpty(emp.getName())){
        CriteriaBuilder.In<String> in = cb.in(name);
        String[] names = emp.getName().split(",");
        Arrays.stream(names).forEach( n -> in.value(n));
        list.add(in);
      }

      if(emp.getId() > 0  || emp.getId() != null){
        Predicate greaterThan = cb.greaterThan(id, emp.getId());
        list.add(greaterThan);
      }

      Predicate predicate = cb.or(list.toArray(new Predicate[list.size()]));

      Order desc = cb.desc(id);

      return query.where(predicate).orderBy(desc).getRestriction();
    });
    findAll.forEach(System.out::println);
  }

  // 原生 JPA
  @Test
  public void jpaGroupByTest() {
    Emp emp = new Emp();
    emp.setId(5L);
    emp.setName("keven,jason,Hellen");
    List<Predicate> list = new ArrayList<>();

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();

    SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session ss = sf.openSession();


    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Emp> cr = cb.createQuery(Emp.class);
    Root<Emp> root = cr.from(Emp.class);
    Path<String> name = root.get("name");
    Path<Long> id = root.get("id");

    if(StringUtils.isEmpty(emp.getName())){
      In<Object> in = cb.in(name);
      String[] names = emp.getName().split(",");
      Arrays.stream(names).forEach( n -> in.value(n));
      list.add(in);
    }

    if(emp.getId() > 0 || emp.getId() != null){
      Predicate gt = cb.gt(id, emp.getId());
      list.add(gt);
    }

    Predicate predicate = cb.or(list.toArray(new Predicate[list.size()]));


    Order desc = cb.desc(id);

    cr.select(root).where(predicate).orderBy(desc);

    Query<Emp> query = ss.createQuery(cr);
    List<Emp> resultList = query.getResultList();
    resultList.forEach(System.out::println);
  }

}
