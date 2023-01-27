package study.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import study.spring.data.pojo.CustomerTwo;

@Component
public interface CustomerTwoRepository extends PagingAndSortingRepository<CustomerTwo, Long> {

}

