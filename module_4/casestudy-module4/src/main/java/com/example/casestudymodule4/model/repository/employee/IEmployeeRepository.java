package com.example.casestudymodule4.model.repository.employee;

import com.example.casestudymodule4.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select e from Employee e where e.employeeName like %?1% and e.flag = 1")
    Page<Employee> findAllByEmployee(String name,Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update employee set flag = 2 where employee_id = ?1",nativeQuery = true)
    void editCustomer(int id);

    @Query(value = "select * from employee where flag = 1",nativeQuery = true)
    List<Employee> findAllList();
}
