package study.spring.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
// import study.spring.data.pojo.QEmp;
import study.spring.data.repository.QueryDSLRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class QueryDSLTest {

  @Autowired
  private QueryDSLRepository queryDSLRepository;

  @PersistenceContext
  private EntityManager em;

  // @Test
  // public void test01() {
  //   QEmp qEmp = QEmp.emp;
  //   // id 完整比對
  //   BooleanExpression eq = qEmp.id.eq(1L);

  //   Optional<Emp> findOne = queryDSLRepository.findOne(eq);
  //   System.out.println(findOne.get());
  // }

  // @Test
  // public void test02() {
  //   QEmp qEmp = QEmp.emp;
  //   BooleanExpression in = qEmp.name
  //       .in("Alice", "Keven")
  //       .or(qEmp.id.eq(10L));
  //   Iterable<Emp> findAll = queryDSLRepository.findAll(in);
  //   findAll.forEach(System.out::println);
  // }

  // @Test
  // public void test03() {
  //   Emp emp = new Emp();
  //   emp.setId(5L);
  //   emp.setName("keven,jason,Hellen");

  //   QEmp qEmp = QEmp.emp;
  //   BooleanExpression expression = qEmp.isNotNull();

  //   expression = emp.getId() > 0 || emp.getId() != null?expression.or(qEmp.id.gt(emp.getId())):expression;
  //   expression = StringUtils.isNotEmpty(emp.getName())?expression.or(qEmp.name.in(emp.getName().split(","))):expression;
  //   Iterable<Emp> findAll = queryDSLRepository.findAll(expression);
  //   findAll.forEach(System.out::println);
  // }

  // @Test
  // public void test04() {
  //   JPAQueryFactory factory = new JPAQueryFactory(em);
  //   QEmp emp = QEmp.emp;

  //   JPAQuery<Tuple> tuple = factory.select(emp.id, emp.name)
  //     .from(emp)
  //     .where(emp.id.eq(1L))
  //     .orderBy(emp.id.desc());

  //   System.out.println(tuple);
  //   List<Tuple> fetch = tuple.fetch();
  //   fetch.forEach(System.out::println);
  // }

}
