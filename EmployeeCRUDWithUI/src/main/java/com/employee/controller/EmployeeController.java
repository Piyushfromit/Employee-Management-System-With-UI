package com.employee.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeservice;
	
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	// List of all Employee 
	// Handler method to handle the list of student and return the mode view 
	@GetMapping("/employees")
	public String getAllEmployee(Model model){
		
		model.addAttribute("employees", employeeservice.getAllEmployee());
		
		return "employees";
		
	}
	
	// Save Employee
	@GetMapping("/employees/new")
	public String createEmployee(Model model) {
		// Creating Student object to hold the object 
		Employee emp = new Employee();
		model.addAttribute("empobj", emp);
		
		return "addemployee";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeservice.saveEmployee(employee);
		
		return "redirect:/employees";
		
		
	}
	
	
	// Update Employee
	@GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Integer id, Model model) {
        
		model.addAttribute("empobj", employeeservice.getEmployeeById(id));
		
		return "editemployee";
	}
	
	 
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Integer id ,
			              @ModelAttribute("employee") Employee employee , Model model) {
		// get Employee from database by id 
		Employee existingEmp = employeeservice.getEmployeeById(id);
		
		//existingEmp.setEmpId(id);
		existingEmp.setName(employee.getName());
		existingEmp.setMail(employee.getMail());
		existingEmp.setContact(employee.getContact());
		existingEmp.setAddress(employee.getAddress());
		
		// Save Updated Student object
		employeeservice.updateEmployee(existingEmp);
		
		return "redirect:/employees";
		
	}
	
// for delete
	// Handler method to handle delete Employee request
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		
		employeeservice.deleteEmployeeById(id);
		
		return "redirect:/employees";
	}
	
	
}
