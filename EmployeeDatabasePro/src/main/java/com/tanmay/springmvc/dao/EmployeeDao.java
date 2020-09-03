package com.tanmay.springmvc.dao;

import java.util.List;

import com.tanmay.springmvc.model.Employee;

public interface EmployeeDao {
	
	public int save(Employee e);
	
	public int update(Employee e);
	
	public int delete(int id);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
}
