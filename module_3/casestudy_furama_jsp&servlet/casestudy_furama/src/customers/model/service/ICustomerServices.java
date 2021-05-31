package customers.model.service;

import customers.model.bean.Customers;

import java.util.List;

public interface ICustomerServices {
    public List<Customers> selectAllCustomers();
}
