package com.example.casestudymodule4.model.service.contract.Impl;

import com.example.casestudymodule4.model.entity.contract.AttachService;
import com.example.casestudymodule4.model.repository.contract.IAttachServiceRepository;
import com.example.casestudymodule4.model.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
