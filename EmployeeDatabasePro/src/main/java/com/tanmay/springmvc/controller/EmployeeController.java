package com.tanmay.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tanmay.springmvc.dao.EmployeeDaoImpl;
import com.tanmay.springmvc.model.Employee;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeDaoImpl dao;
	
	@RequestMapping("/addEmployee")
	public String addingEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add";
	}
	
	@PostMapping("/save")
	public String saveEmployeeDetails(@ModelAttribute("employee")Employee emp ,Model model) {
		dao.save(emp);
		return "redirect:/details";
	}
	
	@RequestMapping("/details")
	public String viewEmp(Model model) {
		List<Employee> list = dao.getEmployees();
		model.addAttribute("list", list);
		return "details";
	}
	
	@RequestMapping("/editEmp/{id}")
	public String editEmployee(@PathVariable int id,Model model) {
		Employee employee = dao.getEmployee(id);
		model.addAttribute("command", employee);
		return "editForm";
	}
	
	@PostMapping("/editSave")
	public String editSave(@ModelAttribute("employee") Employee emp) {
		dao.update(emp);
		return "redirect:/details";
	}
	
	@RequestMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/details";
	}
}
