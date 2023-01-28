package study.spring.data.springdatajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.data.springdatajpa.pojo.Customer;
import study.spring.data.springdatajpa.repository.CustomerRepository;
import study.spring.data.springdatajpa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Iterable<Customer> getAll() {
    return customerRepository.findAll();
  }

}
