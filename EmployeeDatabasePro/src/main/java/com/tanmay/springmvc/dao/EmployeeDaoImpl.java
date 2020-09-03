package com.tanmay.springmvc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tanmay.springmvc.model.Employee;
import com.tanmay.springmvc.model.EmployeeMapper;

public class EmployeeDaoImpl implements EmployeeDao{

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Employee e) {
		// TODO Auto-generated method stub
		String sql = "insert into employee(fname,lname,designation,salary) values(?,?,?,?)";
		return jdbcTemplate.update(sql, e.getFname(),e.getLname(),e.getDesignation(),e.getSalary());
		
	}

	public int update(Employee e) {
		// TODO Auto-generated method stub
		String sql="update employee set fname=?,lname=?,designation=?,salary=? where id=?";
		return jdbcTemplate.update(sql, e.getFname(),e.getLname(),e.getDesignation(),e.getSalary(),e.getId());
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from employee where id=?";
		return jdbcTemplate.update(sql, id);
		
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new EmployeeMapper());
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		String sql = "select * from employee";
		List<Employee> employee = jdbcTemplate.query(sql,new EmployeeMapper());
		return employee;
	}

}
