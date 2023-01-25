package study.spring.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import study.spring.data.pojo.Emp;

public class JpaTest {

  private static EntityManagerFactory factory;

  @BeforeAll
  public static void init() {
    factory = Persistence.createEntityManagerFactory("hibernateJpa");
  }

  @Test
  public void saveTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();
    final Emp emp = new Emp();
    emp.setName("Bob");
    em.persist(emp);
    tx.commit();
  }

  @Test
  public void findTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    final Emp emp = em.find(Emp.class, 1);
    System.out.println(emp);

    tx.commit();
  }

  @Test
  public void findLazyTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    final Emp emp = em.getReference(Emp.class, 1);
    System.out.println("============================");
    System.out.println(emp);

    tx.commit();
  }

  @Test
  public void updateTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    final Emp emp = new Emp();
    emp.setId(10);
    emp.setName("howard");
    // 原生 JPA merge 若有指定主鍵會先查詢完是否有該筆資料有則更新資料,無則新增資料
    em.merge(emp);

    tx.commit();
  }

  @Test
  public void JPQLTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    final String jpql = "UPDATE Emp set name=:name where id = :id";
    em.createQuery(jpql)
        .setParameter("name", "Hellen")
        .setParameter("id", 1)
        .executeUpdate();
    tx.commit();
  }

  @Test
  public void deleteJPQLTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    final String jpql = "DELETE FROM emp WHERE id = :id";
    em.createNativeQuery(jpql)
      .setParameter("id", 8)
      .executeUpdate();

    tx.commit();
  }

  @Test
  public void deleteTest() {
    final EntityManager em = factory.createEntityManager();
    final EntityTransaction tx = em.getTransaction();
    tx.begin();

    // 若要刪除需先查詢後再刪除,因為刪除資料必須為持久狀態才可執行(JPA 狀態)
    Emp emp = em.find(Emp.class, 7);
    em.remove(emp);

    tx.commit();
  }

}
