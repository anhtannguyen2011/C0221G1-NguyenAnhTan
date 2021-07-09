package com.example.casestudymodule4.model.service.employee;

import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Employee;

import java.util.List;

public interface IAppUserService {
    AppUser findByUserName(String userName);
    void save(AppUser appUser);
    List<AppUser> findAll();

}