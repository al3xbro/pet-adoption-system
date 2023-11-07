package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("customer_first_name"),
                rs.getString("customer_last_name"),
                rs.getString("customer_address"),
                rs.getString("customer_phone"));
    }
}
