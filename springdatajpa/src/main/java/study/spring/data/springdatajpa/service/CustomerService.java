package study.spring.data.springdatajpa.service;

import study.spring.data.springdatajpa.pojo.Customer;

public interface CustomerService {

  Iterable<Customer> getAll();
}
