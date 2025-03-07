package com.example.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
