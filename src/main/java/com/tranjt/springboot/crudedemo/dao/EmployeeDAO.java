package com.tranjt.springboot.crudedemo.dao;

import java.util.List;

import com.tranjt.springboot.crudedemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void delete(int theId);

}
