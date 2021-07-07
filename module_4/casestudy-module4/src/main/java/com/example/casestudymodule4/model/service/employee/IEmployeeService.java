package com.example.casestudymodule4.model.service.employee;

import com.example.casestudymodule4.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable,String name);
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
    void edit(Employee employee);
    List<Employee> listEmployee();
}
