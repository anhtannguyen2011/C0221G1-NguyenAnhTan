package com.example.casestudymodule4.model.service.employee.Impl;

import com.example.casestudymodule4.model.entity.employee.EducationDegree;
import com.example.casestudymodule4.model.repository.employee.IEducationDegreeRepository;
import com.example.casestudymodule4.model.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAdd() {
        return educationDegreeRepository.findAll();
    }
}
