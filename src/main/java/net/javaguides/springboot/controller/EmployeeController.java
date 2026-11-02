package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService; 
	//Display list of employee
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	@GetMapping("/ShownewEmployeeForm")
	public String ShownewEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		//Save emp to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id")long id)
	{
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
