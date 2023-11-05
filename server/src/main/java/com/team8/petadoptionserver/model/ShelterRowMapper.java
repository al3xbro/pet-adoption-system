package com.team8.petadoptionserver.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ShelterRowMapper implements RowMapper<Shelter> {

    @Override
    public Shelter mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Shelter(
                rs.getInt("shelter_id"),
                rs.getString("shelter_name"),
                rs.getString("shelter_address"),
                rs.getString("shelter_phone"),
                rs.getInt("shelter_num_adoptions"));
    }

}