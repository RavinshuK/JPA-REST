package com.blueyonder.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.jpa.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
}
