package com.company.dao.inter;

import com.company.entity.Employee;

import java.util.List;

public interface EmployeeDaoInter {

     List<Employee> getAllEmployees();

     Employee getById(int id);

     boolean updateEmployee(Employee emp);

     boolean addEmployee(Employee emp);

     boolean deleteEmployee(int id);
}
