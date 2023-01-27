package study.spring.data.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
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

  /*
   * 單向關聯 1 對 1
   * cascade
   * ALL, 所有動作都會執行
   * PERSIST, 連動新增
   * MERGE, 連動修改
   * REMOVE, 連動刪除
   * fetch
   * EAGER 立即讀取(預設)
   * LAZY 懶加載
   * orphanRemoval(孤兒移除,預設false) : 當關聯物件變更為 null 時,將一併刪除
   * optional(預設true): 關聯對資料不能為空值
   * mapperBy: 統一由一方維護外鍵,值為另一方的屬性名稱
   */
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true/*, optional = false*/)
  // 設定外鍵欄位
  @JoinColumn(name = "account_id")
  private Account account;

  /*
   * 一對多
   * fetch(預設 LAZY)
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private List<Message> messages;


  /*
   * 多對多
   */
  @ManyToMany(cascade = CascadeType.ALL)
  /*
   * 中間需透過 @JoinTable 指定外鍵
   * name : 中間資料表名稱(選填)
   * joinColumns : 本表關聯外鍵
   * inverseJoinColumns : 對方關聯外鍵(選填)
   */
  @JoinTable(
    name = "tb_customer_role",
    joinColumns = {@JoinColumn(name = "c_id")},
    inverseJoinColumns = {@JoinColumn(name = "r_id")}
  )
  private List<Role> roles;


  private @Version Long version;

  @CreatedBy
  private String createdBy;

  @LastModifiedBy
  private String modifiedBy;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdDate = new Date();

  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date modifiedDate = new Date();

}
