package com.example.casestudymodule4.model.service.contract.Impl;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.repository.contract.IContractRepository;
import com.example.casestudymodule4.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository contractRepository;


    @Override
    public void save(Contract contract) {
        contract.setContractTotalMoney(getTotalMoney(contract));
        contractRepository.save(contract);
    }

    public double getTotalMoney(Contract contract){
        int today = 0;
        double totalMoney= 0;

        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractStartDate());
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractEndDate());
            today = (int) TimeUnit.DAYS.convert((end.getTime() - start.getTime()),TimeUnit.MILLISECONDS);
            if(today == 0){
                today = 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double cost = Double.parseDouble(contract.getService().getServiceCost());
        totalMoney = cost * today;
        return totalMoney;
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Contract contract) {
        contract.setContractTotalMoney(getTotalMoney(contract));
        contractRepository.save(contract);
    }

    @Override
    public void deleleContract(int id) {
        contractRepository.deleleContract(id);
    }

    @Override
    public Page<Contract> searchEmployeeName(String name, Pageable pageable) {
        return contractRepository.findByCustomerCustomerNameContaining(name,pageable);
    }
}
