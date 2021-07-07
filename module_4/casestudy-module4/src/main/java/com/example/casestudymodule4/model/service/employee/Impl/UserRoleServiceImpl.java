package com.example.casestudymodule4.model.service.employee.Impl;

import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.UserRole;
import com.example.casestudymodule4.model.repository.employee.IAppRoleRepository;
import com.example.casestudymodule4.model.repository.employee.IRoleUserRepository;
import com.example.casestudymodule4.model.service.employee.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    IRoleUserRepository userRoleRepository;
    @Autowired
    IAppRoleRepository appRoleRepository;
    @Override
    public void save(AppUser appUser, Long id) {
        this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
