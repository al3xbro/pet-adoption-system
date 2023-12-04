package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Log(
                rs.getInt("pet_id"),
                rs.getInt("customer_id"),
                rs.getInt("volunteer_id"),
                rs.getInt("shelter_id"));
    }
}
