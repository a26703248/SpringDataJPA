package study.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Customer;
import study.spring.data.pojo.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

  // 在物件中查詢另外關聯物件只會依據另一方 id 作為條件,若要其他欄未作條件必須自訂JPQL
  List<Message> findByCustomer(Customer customer);

}
