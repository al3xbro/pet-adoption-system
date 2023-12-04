package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Pet(
                rs.getInt("pet_id"),
                rs.getString("pet_name"),
                rs.getInt("pet_age"),
                rs.getString("pet_species"),
                rs.getString("pet_breed"),
                rs.getString("pet_sex"),
                rs.getString("img"));
    }
}
