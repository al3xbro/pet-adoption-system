package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Volunteer;
import com.team8.petadoptionserver.model.VolunteerRowMapper;
import com.team8.petadoptionserver.model.Shelter;
import com.team8.petadoptionserver.model.ShelterRowMapper;

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
    public Optional<Volunteer> findById(int volunteerId) {
        String sql = """
                SELECT *
                FROM volunteer
                WHERE volunteer_id=?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), volunteerId).stream().findFirst();
    }

    @Override
    public List<Volunteer> findByName(String volunteerName) {
        String sql = """
                SELECT *
                FROM volunteer
                WHERE CONCAT(volunteer_first_name, ' ', volunteer_last_name) LIKE `%?%`;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), volunteerName);
    }

    @Override
    public List<Volunteer> findByShelter(int shelterId) {
        String sql = """
                SELECT *
                FROM volunteer
                WHERE volunteer_shelter_id=?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), shelterId);
    }

    @Override
    public List<Shelter> findShelterForVolunteer(int volunteerID) {
        String sql = """
                SELECT s.*
                FROM shelter s
                INNER JOIN volunteers_at va ON s.shelter_id = va.shelter_id
                WHERE va.volunteer_id=?;
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper(), volunteerID);
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
    public int updateVolunteer(int volunteerId, Volunteer volunteer) {
        String sql = """
                UPDATE volunteer
                SET
                    volunteer_first_name=?,
                    volunteer_last_name=?,
                    volunteer_hours_worked=?
                WHERE volunteer_id=?;
                """;
        return jdbcTemplate.update(sql, volunteer.getFirstName(), volunteer.getLastName(), volunteer.getHoursWorked(),
                volunteerId);
    }

    @Override
    public int deleteVolunteer(int volunteerId) {
        String sql = """
                DELETE FROM volunteer
                WHERE volunteer_id=?;
                """;
        return jdbcTemplate.update(sql, volunteerId);
    }

}
