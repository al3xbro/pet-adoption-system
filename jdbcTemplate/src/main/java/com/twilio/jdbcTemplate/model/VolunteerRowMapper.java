package com.twilio.jdbcTemplate.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VolunteerRowMapper implements RowMapper<Volunteer> {
   @Override
   public Volunteer mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new Volunteer(
               rs.getInt("id"),
               rs.getString("name"),
               rs.getInt("hoursWorked")
       );
   }
}