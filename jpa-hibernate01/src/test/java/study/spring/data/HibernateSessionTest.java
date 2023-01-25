package study.spring.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import study.spring.data.pojo.Emp;

public class HibernateSessionTest {

  private static SessionFactory sf;

  @BeforeAll
  public static void init() {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
    sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  @Test
  public void saveTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      Emp emp = new Emp();
      emp.setName("keven");
      ss.save(emp);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void findTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      Emp findEmp = ss.find(Emp.class, 1);
      System.out.println(findEmp);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void findLazyTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      // 懶加載
      Emp findEmp = ss.load(Emp.class, 1);
      System.out.println("=======================");
      System.out.println(findEmp);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void updateTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      Emp emp = new Emp();
      emp.setId(2);
      emp.setName("Keven");
      ss.saveOrUpdate(emp);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void deleteTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      Emp emp = new Emp();
      emp.setId(2);
      emp.setName("Keven");
      ss.remove(emp);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void hqlTest() {
    try (Session ss = sf.openSession();) {
      Transaction tx = ss.beginTransaction();
      // FROM 類別名稱
      String hql = "FROM Emp where id=:id";
      List<Emp> resultList = ss.createQuery(hql, Emp.class)
          .setParameter("id", 1)
          .getResultList();
      resultList.forEach(System.out::println);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
