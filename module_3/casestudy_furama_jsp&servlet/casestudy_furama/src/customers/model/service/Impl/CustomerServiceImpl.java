package customers.model.service.Impl;

import customers.model.bean.CustomerType;
import customers.model.bean.Customers;
import customers.model.repository.CustomerRepository;
import customers.model.repository.CustomerTypeRepository;
import customers.model.service.ICustomerServices;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerServices {
    CustomerRepository customerRepository = new CustomerRepository();
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<Customers> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public void insertCustomer(Customers customers) throws SQLException {
        customerRepository.insertCustomer(customers);
    }

    @Override
    public CustomerType selectCustomerType(int id) {
      return customerTypeRepository.selectCustomerType(id);
    }
}
