package com.example.casestudymodule4.model.service.contract;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);
    List<ContractDetail> findAllByContract(Contract contract);
}
