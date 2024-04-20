package tms.demo.service;

import java.util.List;

import tms.demo.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
