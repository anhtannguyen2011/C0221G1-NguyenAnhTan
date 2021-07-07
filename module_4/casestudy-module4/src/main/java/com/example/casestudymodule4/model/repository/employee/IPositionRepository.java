package com.example.casestudymodule4.model.repository.employee;

import com.example.casestudymodule4.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
