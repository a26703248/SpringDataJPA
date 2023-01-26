package study.spring.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpRepository;

@ContextConfiguration(classes= SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class SpringDataJpqlTest {

  @Autowired
  private EmpRepository empRepository;

  @Test
  public void jpqlSelectTest() {
    Emp findEmpByName = empRepository.findEmpByName("Jason");
    System.out.println(findEmpByName);
    List<Emp> findEmpByNameOrId = empRepository.findEmpByNameOrId("Alice", 1L);
    findEmpByNameOrId.forEach(System.out::println);
  }

  @Test
  public void jpqlUpdateTest() {
    int updateEmp = empRepository.updateEmp("Jason", 10L);
    System.out.println(updateEmp);
  }

  @Test
  public void jpqlDeleteTest() {
    int deleteEmp = empRepository.deleteEmp(12L);
    System.out.println(deleteEmp);
  }

  @Test
  public void jpqlSelectInsertTest() {
    int res = empRepository.insertEmpBySelect(10L);
    System.out.println(res);
  }

  @Test
  public void jpqlNativeSelectTest() {
    List<Emp> selectEmpByName = empRepository.selectEmpByName("Alice");
    selectEmpByName.forEach(System.out::println);
  }

}
