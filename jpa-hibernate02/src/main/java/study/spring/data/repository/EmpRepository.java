package study.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import study.spring.data.pojo.Emp;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Long> {

  // 查詢
  @Query("FROM Emp where name=:name")
  Emp findEmpByName(@Param("name")String name);

  @Query("FROM Emp where name=?1 or id=?2")
  List<Emp> findEmpByNameOrId(String name, Long id);

  // 修改
  // JPQL 增刪改操作須加上交易和可修改註解
  @Transactional
  @Modifying
  @Query("UPDATE Emp set name = :name where id = :id")
  int updateEmp(@Param("name") String name, @Param("id") Long id);

  // 刪除
  @Transactional
  @Modifying
  @Query("DELETE FROM Emp where id = :id")
  int deleteEmp(@Param("id") Long id);

  // 新增(JPQL 預設不支援 insert 語法,HQL(Hibernate)支援查詢後插入語法)
  @Transactional
  @Modifying
  @Query("INSERT INTO Emp(name) SELECT e.name FROM Emp e where e.id = ?1")
  public int insertEmpBySelect(Long id);

  @Query(value="select id, name from emp where name = :name", nativeQuery = true)
  public List<Emp> selectEmpByName(@Param("name") String name);

}
