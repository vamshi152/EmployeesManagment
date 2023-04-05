package com.employee.mangement.repository;

import com.employee.mangement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee save(Employee employee);

    void delete(Employee employee);
}
