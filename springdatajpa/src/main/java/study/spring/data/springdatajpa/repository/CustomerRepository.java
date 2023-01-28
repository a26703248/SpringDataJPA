package study.spring.data.springdatajpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import study.spring.data.springdatajpa.pojo.Customer;

@Component
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}

