package study.spring.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpMethodNameRepository;

@ContextConfiguration(classes= SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class MethodNameTest {

  @Autowired
  private EmpMethodNameRepository empMethodNameRepository;

  @Test
  public void test01() {
    final List<Emp> findByName = empMethodNameRepository.findByName("Alice");
    findByName.forEach(System.out::println);
  }

  @Test
  public void test02() {
    boolean existByName = empMethodNameRepository.existsByName("Alice");
    System.out.println(existByName);
  }

  @Test
  public void test03() {
    // Iterable<Emp> findAll = empMethodNameRepository.findAll();
    // findAll.forEach(System.out::println);
    int removeById = empMethodNameRepository.removeById(14L);
    System.out.println(removeById);
  }

  @Test
  public void test04() {
    List<Emp> findByNameLike = empMethodNameRepository.findByNameLike("A%");
    findByNameLike.forEach(System.out::println);
  }

}
