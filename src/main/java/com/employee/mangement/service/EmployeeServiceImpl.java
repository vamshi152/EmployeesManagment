package com.employee.mangement.service;

import com.employee.mangement.entity.Employee;
import com.employee.mangement.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepo ;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }


    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setMailId(employee.getMailId());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepo.save(existingEmployee);
    }
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        employeeRepo.delete(employee);
    }


}


