package com.example.casestudymodule4.model.repository.contract;

import com.example.casestudymodule4.model.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
