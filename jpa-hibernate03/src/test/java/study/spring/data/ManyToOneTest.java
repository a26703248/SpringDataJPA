package study.spring.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Customer;
import study.spring.data.pojo.Message;
import study.spring.data.repository.MessageRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class ManyToOneTest {

  @Autowired
  private MessageRepository repository;

  @Test
  public void insertTest() {
    Customer customer = new Customer();
    customer.setCusName("Linda");

    List<Message> list = new ArrayList<>();
    list.add(new Message("你好", customer));
    list.add(new Message("在嗎?", customer));

    repository.saveAll(list);
  }

  @Test
  public void selectTest() {
    Customer customer = new Customer();
    customer.setCusId(1L);
    customer.setCusName("aaa");
    List<Message> findByCustomer = repository.findByCustomer(customer);
    findByCustomer.forEach(System.out::println);
  }

}
