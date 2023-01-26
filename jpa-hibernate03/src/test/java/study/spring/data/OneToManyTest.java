package study.spring.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Customer;
import study.spring.data.pojo.Message;
import study.spring.data.repository.CustomerRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class OneToManyTest {

  @Autowired
  private CustomerRepository repository;

  @Test
  public void insertTest() {
    List<Message> messageList = new ArrayList<>();
    messageList.add(new Message("您好"));
    messageList.add(new Message("在嗎?"));
    Customer customer = new Customer();
    customer.setCusName("Allan");
    customer.setMessages(messageList);

    repository.save(customer);

  }

  @Test
  @Transactional(readOnly = true)
  public void selectTest() {
    Optional<Customer> findById = repository.findById(1L);
    System.out.println("==========================");
    System.out.println(findById.get());
  }

  @Test
  public void deleteTest() {
    repository.deleteById(2L);
  }

}
