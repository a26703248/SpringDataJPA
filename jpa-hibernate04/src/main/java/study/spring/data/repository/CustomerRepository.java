package study.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import study.spring.data.pojo.Customer;

@Component
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}

