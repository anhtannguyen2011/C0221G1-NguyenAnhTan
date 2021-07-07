package com.example.casestudymodule4.model.service.employee.Impl;

import com.example.casestudymodule4.model.entity.employee.AppRole;
import com.example.casestudymodule4.model.repository.employee.IAppRoleRepository;
import com.example.casestudymodule4.model.service.employee.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id).orElse(null);
    }
}