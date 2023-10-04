package com.sample.model.Repository;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sample.model.Employee;
import com.sample.model.UserDto;



public interface UserRep extends JpaRepository<Employee, Integer> {
	
	
//	@Query("SELECT new com.sample.model.UserDto(u.id, u.name, u.email,r.role_id, r.role_name,u.status) " +
//			"FROM Employee u left JOIN Role r ON u.role_id = r.role_id")
//	List<UserDto> getUsersWithRoles();
//
//	
//	@Query("SELECT new  com.sample.model.UserDto(u.id, u.name, u.email, r.role_id, r.role_name, u.status) " +
//			"FROM Employee u left JOIN Role r ON u.role_id = r.role_id " + "WHERE u.name LIKE :searchTerm%")
//	List<UserDto> getUserssearch(@Param("searchTerm") String searchTerm);
//
//	
//	@Query("SELECT new  com.sample.model.UserDto(u.id, u.name, u.email, r.role_id, r.role_name, u.status) " +
//			"FROM Employee u left JOIN Role r ON u.role_id = r.role_id")
//	List<UserDto> getUserspageable(Pageable pageable);
	@Query(value="select u.id,u.name,r.role_id,r.role_name  from Employee u  left JOIN Role r ON u.role_id = r.role_id",nativeQuery = true)
	List<Map<String, String>> getwithrole();
	

	@Query(value="select name from employee where name=?1",nativeQuery = true)
	Map<String, String> getwithrole1(String name);
	

	
}