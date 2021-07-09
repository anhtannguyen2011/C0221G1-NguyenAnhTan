package com.example.casestudymodule4.model.repository.employee;

import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);

}