package study.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Account;
import study.spring.data.pojo.Customer;
import study.spring.data.repository.CustomerRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
class OneToOneTest {

  @Autowired
  private CustomerRepository repository;

  @Test
  public void insertTest() {
    Customer customer = new Customer();
    customer.setCusName("Bob");
    Account account = new Account();
    account.setUsername("bob@gmail.com");
    customer.setAccount(account);
    account.setCustomer(customer);

    repository.save(customer);

  }

  @Test
  @Transactional(readOnly = true)
  public void findTest() {
    Optional<Customer> findById = repository.findById(2L);
    System.out.println("=====================");
    System.out.println(findById.get());
  }

  @Test
  public void deleteTest() {
    repository.deleteById(1L);
  }

  @Test
  public void updateTest() {
    Customer customer = new Customer();
    customer.setCusId(1L);
    customer.setCusName("Hellen");
    customer.setAccount(null);
    repository.save(customer);
  }

}
