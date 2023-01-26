package study.spring.data.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Emp;

public interface EmpSpecificationRepository extends PagingAndSortingRepository<Emp, Long>, JpaSpecificationExecutor<Emp> {

}
