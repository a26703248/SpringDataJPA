package study.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import study.spring.data.pojo.Emp;

public interface EmpQBExampleRepository extends QueryByExampleExecutor<Emp>, PagingAndSortingRepository<Emp, Long> {

}
