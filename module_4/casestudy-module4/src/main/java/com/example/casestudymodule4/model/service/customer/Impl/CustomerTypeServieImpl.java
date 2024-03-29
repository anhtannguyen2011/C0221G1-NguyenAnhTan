package com.example.casestudymodule4.model.service.customer.Impl;

import com.example.casestudymodule4.model.entity.customer.CustomerType;
import com.example.casestudymodule4.model.repository.customer.ICustomerTypeRepository;
import com.example.casestudymodule4.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServieImpl implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
