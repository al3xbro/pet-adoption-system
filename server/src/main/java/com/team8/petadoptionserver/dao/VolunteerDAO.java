package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team8.petadoptionserver.model.Volunteer;
import com.team8.petadoptionserver.model.VolunteerRowMapper;

@Component
public class VolunteerDAO implements VolunteerDAOInt {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VolunteerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Volunteer> findAll() {
        String sql = """
                SELECT *
                FROM volunteer
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper());
    }

    @Override
    public Optional<Volunteer> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Volunteer> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Volunteer> findByHoursWorked(int hoursWorked) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByHoursWorked'");
    }

    @Override
    public int addVolunteer(Volunteer volunteer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addVolunteer'");
    }

    @Override
    public int updateVolunteer(int id, Volunteer volunteer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVolunteer'");
    }

    @Override
    public int deleteVolunteer(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVolunteer'");
    }

}
