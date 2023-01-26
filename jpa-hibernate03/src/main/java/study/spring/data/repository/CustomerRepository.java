package study.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
