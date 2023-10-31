package com.petaddoption.application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petaddoption.application.model.Volunteer;
import com.petaddoption.application.model.VolunteerRowMapper;

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
                INSERT INTO Volunteer(volunteer_id,volunteer_name,hours_worked)
                VALUES (?,?,?);
                    """;
        return jdbcTemplate.update(sql, volunteer.getID(), volunteer.getName(), volunteer.getHoursWorked());
    }

    @Override
    public int deleteVolunteer(int id) {
        String sql = """
                DELETE FROM Volunteer
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Volunteer> findAll() {
        String sql = """
                SELECT volunteer_id, volunteer_name, hours_worked
                FROM Volunteer
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper()); // TODO: i think depreciated but idk what else to use
    }

    @Override
    public Optional<Volunteer> findById(int id) {
        String sql = """
                SELECT volunteer_id, volunteer_name, hours_worked
                FROM Volunteer
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Volunteer> findByName(String name) {
        String sql = """
                SELECT volunteer_id, volunteer_name, hours_worked
                FROM Volunteer
                WHERE name = ?;
                """;
        return jdbcTemplate.query(sql, new VolunteerRowMapper()); // TODO: i think depreciated but idk what else to use
    }

    @Override
    public int updateVolunteer(int id, Volunteer volunteer) {
        String sql = """
                UPDATE Volunteer
                SET volunteer_name = ?, hours_worked = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, volunteer.getName(), volunteer.getHoursWorked(), id);
    }

}
