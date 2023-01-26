package study.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import study.spring.data.pojo.Emp;

public interface EmpMethodNameRepository extends PagingAndSortingRepository<Emp, Long> {

  List<Emp> findByName(String name);

  boolean existsByName(String name);

  @Transactional
  @Modifying
  int removeById(Long id);

  List<Emp> findByNameLike(String name);

}
