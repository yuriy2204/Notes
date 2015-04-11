package com.yuriyb.notes.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuriyb.notes.domain.Employee;
import com.yuriyb.notes.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/index")
	public String listEmployees(Map<String, Object> map){
		map.put("employee", new Employee());
		map.put("employeeList", employeeService.listEmployee());
		return "employee";
	}
	
	@RequestMapping("/")
	public String home(){
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result){
		employeeService.addEmployee(employee);
		return "redirect:/index";
	}
	
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId){
		employeeService.removeEmployee(employeeId);
		return "redirect:/index";
	}
}
