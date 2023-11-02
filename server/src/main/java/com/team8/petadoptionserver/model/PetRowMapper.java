package com.team8.petadoptionserver.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Pet(
                rs.getInt("pet_id"),
                rs.getString("pet_name"),
                rs.getInt("pet_age"));
    }
}