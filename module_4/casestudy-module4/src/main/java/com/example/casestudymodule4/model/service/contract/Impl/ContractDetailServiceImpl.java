package com.example.casestudymodule4.model.service.contract.Impl;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.contract.ContractDetail;
import com.example.casestudymodule4.model.repository.contract.IContractDetailRepository;
import com.example.casestudymodule4.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return contractDetailRepository.findAllByContract(contract);
    }
}
