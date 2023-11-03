package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VolunteerRowMapper implements RowMapper<Volunteer> {

    @Override
    public Volunteer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Volunteer(
                rs.getInt("volunteer_id"),
                rs.getString("volunteer_first_name"),
                rs.getString("volunteer_last_name"),
                rs.getInt("volunteer_hours_worked"));
    }
}