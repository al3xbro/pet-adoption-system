package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Log(
                rs.getInt("adopt_id"),
                rs.getString("pet_name"),
                rs.getString("customer_first_name") + " " + rs.getString("customer_last_name"),
                rs.getString("volunteer_first_name") + " " + rs.getString("volunteer_last_name"),
                rs.getString("shelter_name"));
    }
}
