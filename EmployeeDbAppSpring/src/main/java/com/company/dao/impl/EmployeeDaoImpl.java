package com.company.dao.impl;

import com.company.dao.inter.EmployeeDaoInter;
import com.company.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDaoInter{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> listEmployees = new ArrayList<>();
        return listEmployees;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        em.merge(emp);
        return true;
    }

    @Override
    public boolean addEmployee(Employee emp) {
        em.persist(emp);
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
        return true;
    }


}
