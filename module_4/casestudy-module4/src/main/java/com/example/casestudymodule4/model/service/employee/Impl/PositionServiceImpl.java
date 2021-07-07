package com.example.casestudymodule4.model.service.employee.Impl;

import com.example.casestudymodule4.model.entity.employee.Position;
import com.example.casestudymodule4.model.repository.employee.IPositionRepository;
import com.example.casestudymodule4.model.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
