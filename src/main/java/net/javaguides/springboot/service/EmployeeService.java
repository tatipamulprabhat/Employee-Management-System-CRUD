package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService 
{
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	//Update code
	Employee getEmployeeById(long id);
	
	
	//Delete
	void deleteEmployeeById(long id);
}
