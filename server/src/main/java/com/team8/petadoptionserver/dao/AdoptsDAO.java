package com.team8.petadoptionserver.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Log;
import com.team8.petadoptionserver.model.LogRowMapper;

@Repository
public class AdoptsDAO implements AdoptsDAOInt {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdoptsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Log> findAll() {
        String sql = """
                SELECT
                    a.adopt_id,
                    p.pet_name,
                    c.customer_first_name,
                    c.customer_last_name,
                    v.volunteer_first_name,
                    v.volunteer_last_name,
                    s.shelter_name
                FROM adopts a
                LEFT JOIN pet p ON a.pet_id = p.pet_id
                LEFT JOIN customer c ON a.customer_id = c.customer_id
                LEFT JOIN volunteer v ON a.volunteer_id = v.volunteer_id
                LEFT JOIN shelter s ON a.shelter_id = s.shelter_id;
                """;
        return jdbcTemplate.query(sql, new LogRowMapper());
    }

    @Override
    public int addAdoption(Log log) {
        String sql = """
                INSERT INTO adopts (pet_id, customer_id, volunteer_id, shelter_id, adopt_date)
                VALUES (?, ?, ?, ?, CURDATE());
                """;
        return jdbcTemplate.update(sql, new LogRowMapper(), log.getPetName(), log.getCustomerName(),
                log.getVolunteerName(),
                log.getShelterName());
    }

}
