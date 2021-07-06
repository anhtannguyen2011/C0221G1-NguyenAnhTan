package com.example.casestudymodule4.model.repository.customer;

import com.example.casestudymodule4.model.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
