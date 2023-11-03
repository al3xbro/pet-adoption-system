package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Volunteer;
import com.team8.petadoptionserver.model.VolunteerRowMapper;

@Repository
public class VolunteerDAO implements VolunteerDAOInt {

    private final JdbcTemplate jdbcTemplate;

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
        String sql = """
                SELECT *
                FROM volunteer
                WHERE volunteer_id=?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Volunteer> findByName(String name) {
        String sql = """
                SELECT *
                FROM volunteer
                WHERE CONCAT(volunteer_first_name, ' ', volunteer_last_name) LIKE %?%;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), name);
    }

    @Override
    public int addVolunteer(Volunteer volunteer) {
        String sql = """
                INSERT INTO volunteer (
                    volunteer_first_name,
                    volunteer_last_name,
                    volunteer_hours_worked
                )
                VALUES (?,?,?);
                """;
        return jdbcTemplate.update(sql, volunteer.getFirstName(), volunteer.getLastName(), volunteer.getHoursWorked());
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
