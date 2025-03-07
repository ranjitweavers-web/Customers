package com.example.curd.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.curd.model.Customer;
import com.example.curd.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
   

    @PostMapping
    // create new customer
    public Customer createNewCustomer(@RequestBody Customer customer) {
        if(customer.getPassword() == null || customer.getPassword().isEmpty()){
            throw new IllegalArgumentException("password can't be null or empty");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return customerRepository.save(customer);
    }

    // update Customer by id
    public Customer updateCustomer(Long id, Customer updateCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(updateCustomer.getName());
            customer.setEmail(updateCustomer.getEmail());
            customer.setPassword(passwordEncoder.encode(updateCustomer.getPassword()));
            customer.setAddress((updateCustomer.getPassword()));
            return customerRepository.save(customer);

        } else {
            throw new RuntimeException("Customer not found with given ID " + id);
        }

    }

    // show all customer

    public List<Customer> showAllCustomer() {
        return customerRepository.findAll();
    }

    // Delete Customer by id

    public void deleteCustomer(Long id) {

        Optional<Customer> availablityCheck = customerRepository.findById(id);
        if (availablityCheck.isPresent()) {
            customerRepository.deleteById(id);

        } else {
            throw new RuntimeException("Customer not found with given id" + id);
        }

    }

}
