package study.spring.data.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_message")
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String info;

  // 多對一
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id") // 若雙向關聯其中一方有 JoinColumn 即可
  private Customer customer;

  // 無參數建構子必須要有不然select會錯誤
  public Message() {
  }

  public Message(String info, Customer customer) {
    this.info = info;
    this.customer = customer;
  }

  public Message(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "Message [id=" + id + ", info=" + info + ", customerCusId=" + customer.getCusId() + ", customerCusName=" + customer.getCusName() + "]";
  }


}
