package com.example.casestudymodule4.model.service.service;

import com.example.casestudymodule4.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save(Service service);
    List<Service> findAll();
    Page<Service> findAllByService(Pageable pageable);
}
