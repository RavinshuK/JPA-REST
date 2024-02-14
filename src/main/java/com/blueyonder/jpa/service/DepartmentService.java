package com.blueyonder.jpa.service;

import java.util.List;

import com.blueyonder.jpa.entity.Department;

public interface DepartmentService {
	void addDepartment(Department dep);
	List<Department> getAllData();
	Department getDepbyDepid(int depid);
	Department updateDepartment(int depid);
	void deleteDepartment(int depid);
	
}
