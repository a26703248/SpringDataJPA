package study.spring.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpQBExampleRepository;

@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class QBETest {

  @Autowired
  private EmpQBExampleRepository empQBExampleRepository;

  @Test
  public void test01() {

    // 條件物件設定
    Emp emp = new Emp();
    emp.setName("jason");
    // emp.setId(10L);

    ExampleMatcher matching = ExampleMatcher.matching()
        // 忽略欄位
        // .withIgnorePaths("id")
        // 忽略大小寫
        .withIgnoreCase("name")
        // 設定開頭 | 結尾 | 包含 匹配
        // .withStringMatcher(StringMatcher.ENDING);
        // 針對個別欄位自訂條件
        // .withMatcher("name", m -> m.startsWith());
        // 將會忽略前方非 withMatcher 所設定的相同欄位條件,且變為完整比對(MySQL 預設 IgnoreCase)
        .withMatcher("name", m -> ExampleMatcher.GenericPropertyMatchers.endsWith());

    // 條件建構
    Example<Emp> ex = Example.of(emp, matching);

    List<Emp> findAll = (List<Emp>) empQBExampleRepository.findAll(ex);
    findAll.forEach(System.out::println);
  }

}
