package customers.model.service.Impl;

import customers.model.bean.Customers;
import customers.model.repository.CustomerRepository;
import customers.model.service.ICustomerServices;

import java.util.List;

public class CustomerServiceImpl implements ICustomerServices {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customers> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }
}
