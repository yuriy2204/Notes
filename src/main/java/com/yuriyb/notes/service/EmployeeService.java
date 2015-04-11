package com.yuriyb.notes.service;

import java.util.List;

import com.yuriyb.notes.domain.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> listEmployee();
	
	public void removeEmployee(Integer id);

}
