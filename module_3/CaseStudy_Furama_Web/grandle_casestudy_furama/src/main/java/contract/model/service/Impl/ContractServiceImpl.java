package contract.model.service.Impl;

import contract.model.bean.Contract;
import contract.model.repository.ContractRepository;
import contract.model.service.IContractService;

public class ContractServiceImpl implements IContractService {
    ContractRepository contractRepository = new ContractRepository();

    @Override
    public void insertContract(Contract contract) {
        contractRepository.insertContract(contract);
    }
}
