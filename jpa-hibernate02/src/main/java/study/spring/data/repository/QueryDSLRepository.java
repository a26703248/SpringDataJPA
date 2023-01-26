package study.spring.data.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Emp;

public interface QueryDSLRepository extends PagingAndSortingRepository<Emp, Long>, QuerydslPredicateExecutor<Emp>{

}
