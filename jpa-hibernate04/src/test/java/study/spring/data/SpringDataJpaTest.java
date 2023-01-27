package study.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Customer;
import study.spring.data.repository.CustomerRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class SpringDataJpaTest {

  @Autowired
  private CustomerRepository repository;

  @Test
  public void test() {
    Optional<Customer> findById = repository.findById(1L);
    System.out.println(findById.get());
  }
}
