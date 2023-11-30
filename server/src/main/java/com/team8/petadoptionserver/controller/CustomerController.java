package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team8.petadoptionserver.dao.CustomerDAO;
import com.team8.petadoptionserver.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/id/{id}")
    public Optional<Customer> findById(@PathVariable("id") int id) {
        return customerDAO.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Customer> findByName(@PathVariable("name") String name) {
        return customerDAO.findByName(name);
    }

    @GetMapping("/address/{address}")
    public List<Customer> findByAddress(@PathVariable("address") String address) {
        return customerDAO.findByAddress(address);
    }

    @GetMapping("/phone/{phone}")
    public List<Customer> findByPhone(@PathVariable("phone") String phone) {
        return customerDAO.findByPhone(phone);
    }

    @PostMapping({ "", "/" })
    public int addCustomer(@RequestBody Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    @PutMapping("/update/{id}")
    public int updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        return customerDAO.updateCustomer(id, customer);
    }

    @GetMapping("/delet/{id}")
    public int deletePet(@PathVariable("id") int id) {
        return customerDAO.deleteCustomer(id);
    }
}