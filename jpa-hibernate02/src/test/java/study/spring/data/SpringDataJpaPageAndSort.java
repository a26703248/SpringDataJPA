package study.spring.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.SpringDataJpaConfig;
import study.spring.data.pojo.Emp;
import study.spring.data.repository.EmpRepository;

@ContextConfiguration(classes= SpringDataJpaConfig.class)
@ExtendWith(SpringExtension.class)
public class SpringDataJpaPageAndSort {

  @Autowired
  private EmpRepository empRepository;

  @Test
  public void pageTest() {
    Page<Emp> findAll = empRepository.findAll(PageRequest.of(0, 3));
    System.out.println(findAll.getTotalPages());
    System.out.println(findAll.getTotalElements());
    System.out.println(findAll.getContent());
  }

  @Test
  public void sortedTest() {
    Sort sorted = Sort.by("name").descending();
    Iterable<Emp> findAll = empRepository.findAll(sorted);
    findAll.forEach(System.out::println);
  }

  @Test
  public void typeSortTest() {
    Sort.TypedSort<Emp> sortType = Sort.sort(Emp.class);
    Sort sorted = sortType.by(Emp::getName).descending();
    Iterable<Emp> findAll = empRepository.findAll(sorted);
    findAll.forEach(System.out::println);
  }

}
