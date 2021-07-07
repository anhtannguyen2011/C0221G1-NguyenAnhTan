package com.example.casestudymodule4.model.repository.service;

import com.example.casestudymodule4.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
