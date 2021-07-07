package com.example.casestudymodule4.model.service.service.Impl;

import com.example.casestudymodule4.model.entity.service.RentType;
import com.example.casestudymodule4.model.repository.service.IRentTypeRepository;
import com.example.casestudymodule4.model.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository repository;

    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
