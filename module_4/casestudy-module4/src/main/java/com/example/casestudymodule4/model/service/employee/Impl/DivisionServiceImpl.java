package com.example.casestudymodule4.model.service.employee.Impl;

import com.example.casestudymodule4.model.entity.employee.Division;
import com.example.casestudymodule4.model.repository.employee.IDivisionRepository;
import com.example.casestudymodule4.model.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAdd() {
        return divisionRepository.findAll();
    }
}
