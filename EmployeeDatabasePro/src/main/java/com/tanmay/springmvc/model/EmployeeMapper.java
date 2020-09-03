package com.tanmay.springmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setFname(rs.getString(2));
		emp.setLname(rs.getString(3));
		emp.setDesignation(rs.getString(4));
		emp.setSalary(rs.getInt(5));
		
		return emp;
	}
	

}
