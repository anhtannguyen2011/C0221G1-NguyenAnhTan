package com.example.casestudymodule4.model.service.contract.Impl;

import com.example.casestudymodule4.model.entity.contract.ContractDetail;
import com.example.casestudymodule4.model.repository.contract.IContractDetailRepository;
import com.example.casestudymodule4.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
