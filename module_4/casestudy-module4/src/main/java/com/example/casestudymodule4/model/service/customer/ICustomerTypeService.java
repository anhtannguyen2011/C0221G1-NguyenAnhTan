package com.example.casestudymodule4.model.service.customer;

import com.example.casestudymodule4.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
