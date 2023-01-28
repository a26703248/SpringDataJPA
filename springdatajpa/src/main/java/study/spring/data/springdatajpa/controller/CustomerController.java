package study.spring.data.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.spring.data.springdatajpa.pojo.Customer;
import study.spring.data.springdatajpa.service.CustomerService;

@RestController
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping("/customer/all")
  public Iterable<Customer> getAll() {
    return customerService.getAll();
  }

}

