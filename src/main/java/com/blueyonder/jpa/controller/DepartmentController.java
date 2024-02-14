//package com.blueyonder.jpa.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.blueyonder.jpa.entity.Department;
//import com.blueyonder.jpa.repo.DepartmentRepo;
//import com.blueyonder.jpa.service.DepartmentService;
//
//@Controller 
//public class DepartmentController {
//	
//	@Autowired
//	DepartmentRepo repo;
//	@Autowired
//	DepartmentService service;
//	
//	@GetMapping("/")
//	public String getDepartment() {
//		
//		
//		return "result";
//	}
//	
//	@GetMapping("/departments")
//	public String getDepartments() {
//		List<Department> list=service.getAllData();
//		return list.toString();
//		
//	}
//}
