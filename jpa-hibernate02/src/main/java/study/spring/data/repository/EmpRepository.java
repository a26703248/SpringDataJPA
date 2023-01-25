package study.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import study.spring.data.pojo.Emp;

public interface EmpRepository extends CrudRepository<Emp, Long> {

}
