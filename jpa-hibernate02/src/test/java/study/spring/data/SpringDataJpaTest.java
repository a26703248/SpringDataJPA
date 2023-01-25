package study.spring.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpRepository;

@ContextConfiguration(classes= SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class SpringDataJpaTest {

  @Autowired
  private EmpRepository empRepository;

  @Test
  public void selectFind() {
    Iterable<Emp> findAll = empRepository.findAll();
    findAll.forEach(System.out::println);
  }

  @Test
  public void createTest() {
    Emp emp = new Emp();
    System.out.println(emp);
    emp.setName("Linda");
    Emp persist = empRepository.save(emp);
    System.out.println(persist);
  }

  @Test
  public void updateTest() {
    Emp emp = new Emp();
    emp.setId(10L);
    emp.setName("Jack");
    empRepository.save(emp);
  }

  @Test
  public void deleteTest() {
    Emp emp = new Emp();
    emp.setId(11L);
    empRepository.delete(emp);
  }

}
