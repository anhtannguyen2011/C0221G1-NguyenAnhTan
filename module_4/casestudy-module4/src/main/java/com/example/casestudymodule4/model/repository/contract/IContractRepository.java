package com.example.casestudymodule4.model.repository.contract;

import com.example.casestudymodule4.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
//    @Query(value = "select * from contract where contract_id = ?1 and flag = 1",nativeQuery = true)
//    Page<Contract> findAllContract(String name, Pageable pageable);
    @Query(value = "select * from contract where flag = 1",nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "update contract set flag = 2 where contract_id = ?1",nativeQuery = true)
    void deleleContract(int id);

    Page<Contract> findByCustomerCustomerNameContaining(String name,Pageable pageable);
}
