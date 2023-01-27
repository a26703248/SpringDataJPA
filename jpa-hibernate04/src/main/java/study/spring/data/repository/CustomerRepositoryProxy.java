package study.spring.data.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Customer;

public class CustomerRepositoryProxy implements PagingAndSortingRepository<Customer, Long> {

  EntityManager em;

  Class<? extends Customer> pojoClass;



  public CustomerRepositoryProxy(EntityManager em, Class<? extends Customer> pojoClass) {
    this.em = em;
    this.pojoClass = pojoClass;
  }

  @Override
  public <S extends Customer> S save(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return Optional.of(em.find(pojoClass, id));
  }

  @Override
  public boolean existsById(Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterable<Customer> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<Customer> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Customer entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> ids) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll(Iterable<? extends Customer> entities) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub

  }

  @Override
  public Iterable<Customer> findAll(Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<Customer> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

}
