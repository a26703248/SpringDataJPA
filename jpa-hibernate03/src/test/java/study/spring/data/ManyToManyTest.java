package study.spring.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Customer;
import study.spring.data.pojo.Role;
import study.spring.data.repository.CustomerRepository;
import study.spring.data.repository.RoleRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class ManyToManyTest {

  @Autowired
  private CustomerRepository repository;

  @Autowired
  private RoleRepository roleRepository;

  /*
   * 若需關聯已存在資料須查詢過後再寫入並增加事務管理
   */
  @Test
  @Transactional
  @Commit
  public void insertTest() {
    Customer customer = new Customer();
    customer.setCusName("Bob");

    List<Role> list = new ArrayList<>();
    list.add(roleRepository.findById(1L).get());
    list.add(roleRepository.findById(2L).get());

    customer.setRoles(list);

    repository.save(customer);
  }

  @Test
  @Transactional(readOnly = true)
  public void selectTest() {
    Optional<Customer> findById = repository.findById(3L);
    System.out.println(findById.get());
  }

  /*
   * 再多對多關聯下,若是關聯已存在的物件並要聯集刪除中間表及對方表,
   * 則會拋出 ConstraintViolationException, 因為已存在資料有可能會關聯其他資料
   * https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#associations-many-to-many
   */
  @Test
  @Transactional // 在單元測試中加上 @Transactional 若有增刪改需手動加上 @Commit
  @Commit
  public void deleteTest() {
    Optional<Customer> findById = repository.findById(2L);
    repository.delete(findById.get());
  }


}
