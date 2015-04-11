package com.yuriyb.notes.dao;

import java.util.List;

import com.yuriyb.notes.domain.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> listEmployee();
	
	public void removeEmployee(Integer id);

}
