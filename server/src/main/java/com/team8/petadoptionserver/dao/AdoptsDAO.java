package com.team8.petadoptionserver.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AdoptsDAO implements AdoptsDAOInt{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdoptsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        String sql = """
                SELECT
                    adopt_id,
                    pet_id,
                    pet_name,
                    customer_id,
                    customer_first_name,
                    customer_id,
                    volunteer_first_name,
                    shelter_id,
                    shelter_name
                FROM adopts a
                LEFT JOIN pet p ON a.pet_id = p.pet_id
                LEFT JOIN customer c ON a.customer_id = c.customer_id
                LEFT JOIN volunteer v ON a.volunteer_id = v.volunteer_id
                LEFT JOIN shelter s ON a.shelter_id = s.shelter_id;
                """;
        return jdbcTemplate.queryForList(sql);
    }

}