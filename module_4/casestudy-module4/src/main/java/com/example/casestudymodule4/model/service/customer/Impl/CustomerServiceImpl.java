package com.example.casestudymodule4.model.service.customer.Impl;

import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.repository.customer.ICustomerRepository;
import com.example.casestudymodule4.model.repository.customer.ICustomerTypeRepository;
import com.example.casestudymodule4.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllCustomerList();
    }

    @Override
    public Page<Customer> findAllByNameBlogContaining(String searchName, Pageable pageable) {
        return customerRepository.findAllByNameBlogContaining(searchName,pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.editCustomer(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }
}
