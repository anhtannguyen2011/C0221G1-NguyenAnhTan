package com.example.casestudymodule4.model.repository.service;

import com.example.casestudymodule4.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
