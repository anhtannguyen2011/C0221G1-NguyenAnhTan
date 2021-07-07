package com.example.casestudymodule4.model.repository.service;

import com.example.casestudymodule4.model.entity.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
}
