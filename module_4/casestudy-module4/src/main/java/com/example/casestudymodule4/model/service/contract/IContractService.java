package com.example.casestudymodule4.model.service.contract;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
//    Page<Contract> findAll(String name,Pageable pageable);
    void save(Contract contract);
    List<Contract> findAll();
    Page<Contract> findAllContract(Pageable pageable);
    Contract findById(int id);
    void edit(Contract contract);
    void deleleContract(int id);
}
