package com.example.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.Services.CustomerService;
import com.example.curd.model.Customer;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
 private CustomerService customerService;

 @PostMapping("/new")
 public Customer createNewCustomer(@RequestBody Customer customer){
    System.out.println(customer);
        return customerService.createNewCustomer(customer);
 }

 @PutMapping("update/{id}")
 public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
    
             Customer updateCustomer = customerService.updateCustomer(id, customer);
             return ResponseEntity.ok(updateCustomer);
     
 }

 @GetMapping("/all")
 public List<Customer> allCustomer(){
     return customerService.showAllCustomer();
 }

 @DeleteMapping("delete/{id}")
 public void deleteCustomer(@PathVariable Long id){
              customerService.deleteCustomer(id);
 }




}
