package study.spring.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import study.spring.data.pojo.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
