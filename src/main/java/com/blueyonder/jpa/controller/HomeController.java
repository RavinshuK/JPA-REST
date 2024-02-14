package com.blueyonder.jpa.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import com.blueyonder.jpa.entity.Department;
import com.blueyonder.jpa.repo.DepartmentRepo;
import com.blueyonder.jpa.service.DepartmentService;

@RestController
//@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	DepartmentRepo repo;
	@Autowired
	DepartmentService service;
	
	public HomeController(DepartmentService service) {
	super();
	this.service = service;
}

	@GetMapping	("/")
	public String Details() {
		return "index";
	}
	

	@PostMapping("/submit")
	public String storeInDB(@RequestParam("depid") Integer depid, 
            @RequestParam("depname") String depname, 
            @RequestParam("deplocation") String deplocation) {
			// Create a Department object from form data
			Department department = new Department();
			department.setDepid(depid);
			department.setDepname(depname);
			department.setDeplocation(deplocation);
			// Add the department to the database
			service.addDepartment(department);
			System.out.println("Data inserted");
			// Print message
			return "redirect:/";
			
	} 
	
	@GetMapping("/getData")
	public String getData(Model m) {
		m.addAttribute("fullname", service.getAllData());
		return "result";
	}
	
	@GetMapping("/byId")
	public String getById(@RequestParam("depid") int depid,Model m) {
		m.addAttribute("fullname", service.getDepbyDepid(depid));
		return "result";
	}

	
	//REST CONTROLLER
	@GetMapping("/departments")
//	@ResponseBody
	public List<Department> getDepartments() {
		List <Department> list= service.getAllData();
		System.out.println(Arrays.toString(list.toArray()));
		return list;
}
	@GetMapping("/department/{depid}")
//	@ResponseBody
	public Department getByIdREST(@PathVariable("depid") int depid) {
		Department list= service.getDepbyDepid(depid);
		return list;
	}
	
	@PostMapping("/department/add")
	@ResponseBody
	public Department addDep(Department department) {
		service.addDepartment(department);
//		repo.save(department);
		return department;
	}
	
	@RequestMapping("/department/delete/{depid}")
	public void deleteByID(@PathVariable("depid") int depid) {
		service.deleteDepartment(depid);
		System.out.println("Deleted record with depid "+depid);
	}
	
	@PutMapping("/department/update/{depid}")
	@ResponseBody
	public void updateDep(@PathVariable("depid") int depid, Department department) {
		Department dep = service.updateDepartment(depid);
//		dep.setDepid(department.getDepid());
		dep.setDepname(department.getDepname());
		dep.setDeplocation(department.getDeplocation());
		service.addDepartment(dep);
		System.out.println("Updated record with depid "+depid);
				
	}
}