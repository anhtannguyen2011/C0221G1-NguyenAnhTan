package com.example.casestudymodule4.model.service.employee.Impl;
import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Employee;
import com.example.casestudymodule4.model.repository.employee.IAppUserRepository;
import com.example.casestudymodule4.model.service.employee.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Override
    public AppUser findByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }




//    public static void main(String[] args) {
//        AppUserServiceImpl appUserService = new AppUserServiceImpl();
//        appUserService.getByEmployeeName("dbuser1");
//    }
}
