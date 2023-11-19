package com.team8.petadoptionserver.dao;

import com.team8.petadoptionserver.model.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAOInt {
    List<Customer> findAll();
    Optional<Customer> findById(int customerId);
    List<Customer> findByName(String customerName);
    List<Customer> findByAddress(String customerAddress);
    List<Customer> findByPhone(String customerPhone);

    int addCustomer(Customer customer);

    int uptdateCustomer(int customerId, Customer customer);

    int deleteCustomer(int customerId);
}