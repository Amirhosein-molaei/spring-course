package com.molaei.service;

import com.molaei.data.CustomerDAOImpl;
import com.molaei.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAOImpl customerDAO;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        //		if(customer.getPassword()!=null){
//			String pass=customer.getPassword();
//			customer.setPassword(passwordEncoder.encode(pass));
//		}
        customerDAO.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findCustomerByUsername(String username) {
        return customerDAO.findUserByusername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomerByCustomerId(Long customerId) {
        return customerDAO.findOne(customerId);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return customerDAO.findCustomerByUsernameAndPassword(username, password);
    }
}
