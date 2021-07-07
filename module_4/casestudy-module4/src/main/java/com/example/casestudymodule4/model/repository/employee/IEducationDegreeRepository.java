package com.example.casestudymodule4.model.repository.employee;

import com.example.casestudymodule4.model.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
