package com.example.casestudymodule4.model.service.service;

import com.example.casestudymodule4.model.entity.service.Service;

import java.util.List;

public interface IServiceService {
    void save(Service service);
    List<Service> findAll();
}
