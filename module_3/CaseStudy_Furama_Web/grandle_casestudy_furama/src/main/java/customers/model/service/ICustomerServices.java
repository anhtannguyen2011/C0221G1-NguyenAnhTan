package customers.model.service;

import customers.model.bean.CustomerType;
import contract.model.bean.CustomerUseService;
import customers.model.bean.Customers;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerServices {
    public List<Customers> selectAllCustomers();
    boolean insertCustomer(Customers customers) throws SQLException;

    CustomerType selectCustomerType(int id);

    boolean deleteCustomer(int id);

    boolean updateCustomer(Customers customers);

    Customers selectCustomer(int id);

    List<Customers> searchByName(String name);
    public List<CustomerType> selectAllCustomerType();


}
