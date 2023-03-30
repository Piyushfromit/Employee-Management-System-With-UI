package com.employee.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository er;
	
	
	public EmployeeServiceImpl(EmployeeRepository sr) {
		super();
		this.er = sr;
	}


	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> list = er.findAll();
		if (list.size() == 0) {
			throw new EmployeeException("No any Student Found");
		}
		return list;
	}


	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeException {

       if(employee == null) {
    	   throw new EmployeeException("Enter valid data");
       }
       
       return er.save(employee);
       
	}


	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		
		Optional<Employee> opt = er.findById(employee.getEmpId());
		if (opt.isPresent()) {
			er.save(employee);
			
		} else {
			throw new EmployeeException("Customer not found");
		}
		return employee;
		 
	}


	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp = er.findById(id);
		
		return emp.orElseThrow(() -> new EmployeeException("Employee not found"));
		
	}


	@Override
	public void deleteEmployeeById(Integer id) throws EmployeeException {
		Optional<Employee> opt = er.findById(id);
		if (opt.isPresent()) {
			er.delete(opt.get());
		} else {
			throw new EmployeeException("Customer not found");
		}
		//return opt.get();
	}




	

}
