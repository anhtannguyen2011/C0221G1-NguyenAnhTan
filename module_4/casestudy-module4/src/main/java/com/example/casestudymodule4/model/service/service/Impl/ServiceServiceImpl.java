package com.example.casestudymodule4.model.service.service.Impl;

import com.example.casestudymodule4.model.entity.service.Service;
import com.example.casestudymodule4.model.repository.service.IServiceRepository;
import com.example.casestudymodule4.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public void save(Service service) {
      serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAllByService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }
}
