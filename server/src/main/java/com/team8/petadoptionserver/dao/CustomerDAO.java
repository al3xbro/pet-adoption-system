package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Customer;
import com.team8.petadoptionserver.model.CustomerRowMapper;

@Repository
public class CustomerDAO implements CustomerDAOInt {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAll() {
        String sql = """
                SELECT *
                FROM customer
                LIMIT 100;
                """;

        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    @Override
    public Optional<Customer> findById(int customerId) {
        String sql = """
                SELECT *
                FROM customer
                WHERE customer_id = ?;
                """;

        return jdbcTemplate.query(sql, new CustomerRowMapper(), customerId).stream().findFirst();
    }

    @Override
    public List<Customer> findByName(String customerName) {
        String sql = """
                SELECT *
                FROM customer
                WHERE customer_name = ?;
                """;

        return jdbcTemplate.query(sql, new CustomerRowMapper(), customerName);
    }

    @Override
    public List<Customer> findByAddress(String customerAddress) {
        String sql = """
                SELECT *
                FROM customer
                WHERE customer_address = ?;
                """;

        return jdbcTemplate.query(sql, new CustomerRowMapper(), customerAddress);
    }

    @Override
    public List<Customer> findByPhone(String customerPhone) {
        String sql = """
                SELECT *
                FROM customer
                WHERE customer_phone = ?;
                """;

        return jdbcTemplate.query(sql, new CustomerRowMapper(), customerPhone);
    }

    @Override
    public int addCustomer(Customer customer) {
        String sql = """
                INSERT INTO customer (customer_first_name, customer_last_name, customer_address, customer_phone)
                VALUES (?, ?, ?, ?);
                """;

        return jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getPhone());
    }

    @Override
    public int updateCustomer(int customerId, Customer customer) {
        String sql = """
                UPDATE customer
                SET customer_first_name = ?, customer_last_name = ?, customer_address = ?, customer_phone = ?
                WHERE customer_id = ?;
                """;

        return jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getPhone(), customer.getId());
    }

    @Override
    public int deleteCustomer(int customerId) {
        String sql = """
                DELETE FROM customer
                WHERE customer_id = ?;
                """;

        return jdbcTemplate.update(sql, customerId);
    }
}