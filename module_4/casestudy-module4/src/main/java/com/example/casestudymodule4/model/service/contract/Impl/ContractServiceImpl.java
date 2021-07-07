package com.example.casestudymodule4.model.service.contract.Impl;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.repository.contract.IContractRepository;
import com.example.casestudymodule4.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository contractRepository;


    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
