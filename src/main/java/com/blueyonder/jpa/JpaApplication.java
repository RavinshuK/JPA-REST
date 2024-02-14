package com.blueyonder.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blueyonder.jpa.entity.Department;
import com.blueyonder.jpa.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	@Autowired 
	DepartmentService depser;
	
	public static void main(String[] args)  {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Department dep=new Department(5,"Medical", "Patiala");
//		dep.setDepid(5);
//		dep.setDepname("Medical");
//		dep.setDeplocation("Patiala");
		
//		depser.addDepartment(dep);
		System.out.println("DATA INSERTED");
		
		
	}

}
