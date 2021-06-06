package contract.model.service;

import contract.model.bean.Contract;
import contract_detail.model.bean.AttachService;
import customers.model.bean.Customers;

import java.util.List;

public interface IContractService {
    void insertContract(Contract contract);
    Contract selectContract(int id);
    List<Contract> selectAllContract();
    List<Contract> selectAllCustomersUseService();
    List<AttachService> selectAllAttach();
    List<Customers> selectAllCustomers();
}
