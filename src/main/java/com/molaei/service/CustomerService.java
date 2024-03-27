package com.molaei.service;

import com.molaei.data.entities.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public Customer findCustomerByUsername(String username);
    List<Customer> getAllCustomers();

    public Customer getCustomerByCustomerId(Long customerId);

    public Customer findCustomerByUsernameAndPassword(String username, String password);
}
