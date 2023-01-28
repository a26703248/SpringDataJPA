package study.spring.data.springdatajpa.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "tb_customer")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long cusId;

  @Column(name = "cus_name")
  private String cusName;

  @Column(name = "cus_address")
  private String cusAddress;

}
