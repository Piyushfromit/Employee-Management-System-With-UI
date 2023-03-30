package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;

@SpringBootApplication
public class EmployeeCrudWithUiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudWithUiApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository empRepo;
	
	

	@Override
	public void run(String... args) throws Exception {
		
//		Employee emp1 = new Employee("Piyush", "piyushfromit@gmail.com", "765765", "patna" );
//		empRepo.save(emp1);
//		
//		
//		Employee emp2 = new Employee("Piyush", "piyushfromit@gmail.com", "765765", "patna" );
//		empRepo.save(emp2);
	
	}

}
