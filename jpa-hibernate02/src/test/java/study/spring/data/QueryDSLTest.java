package study.spring.data;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.SpringDataJpaConfig;
import study.spring.data.repository.QueryDSLRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class QueryDSLTest {

  @Autowired
  private QueryDSLRepository queryDSLRepository;

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

}
