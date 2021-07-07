package com.example.casestudymodule4.model.service.customer;

import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAllByNameBlogContaining(String searchName,Pageable pageable);
    Customer findById(Integer id);
    void remove(Integer id);
    void save(Customer customer);
    void edit(Customer customer);

}
