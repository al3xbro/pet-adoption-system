package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Volunteer;
import com.team8.petadoptionserver.model.VolunteerRowMapper;

@Repository
public class VolunteerDaoImpl implements VolunteerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VolunteerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // adds a volunteer into the database
    @Override
    public int addVolunteer(Volunteer volunteer) {
        String sql = """
                INSERT INTO Volunteer(volunteer_id,volunteer_first_name,volunteer_last_name,hours_worked)
                VALUES(?,?,?);
                    """;
        return jdbcTemplate.update(sql, volunteer.getId(), volunteer.getFirstName(), volunteer.getLastName(),
                volunteer.getHoursWorked());
    }

    @Override
    public int deleteVolunteer(int id) {
        String sql = """
                DELETE FROM Volunteer
                WHERE id=?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Volunteer> findAll() {
        String sql = """
                SELECT *
                FROM Volunteer
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper());
    }

    @Override
    public Optional<Volunteer> findById(int id) {
        String sql = """
                SELECT *
                FROM Volunteer
                WHERE id=?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Volunteer> findByName(String name) {
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[1];
        String sql = """
                SELECT *
                FROM Volunteer
                WHERE volunteer_first_name=? AND volunteer_last_name=?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), firstName, lastName);
    }

    @Override
    public int updateVolunteer(int id, Volunteer volunteer) {
        String sql = """
                UPDATE Volunteer
                SET volunteer_first_name=?,volunteer_last_name=?, hours_worked=?
                WHERE id=?
                """;
        return jdbcTemplate.update(sql, volunteer.getFirstName(), volunteer.getLastName(), volunteer.getHoursWorked(),
                id);
    }

}
