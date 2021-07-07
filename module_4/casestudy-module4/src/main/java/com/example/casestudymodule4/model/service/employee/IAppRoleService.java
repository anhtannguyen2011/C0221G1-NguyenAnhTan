package com.example.casestudymodule4.model.service.employee;

import com.example.casestudymodule4.model.entity.employee.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAll();
    AppRole findById(Long id);
}