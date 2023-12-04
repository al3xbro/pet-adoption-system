package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Shelter;
import com.team8.petadoptionserver.model.ShelterRowMapper;

@Repository
public class ShelterDAO implements ShelterDAOInt {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShelterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Shelter> findAll() {
        String sql = """
                SELECT *
                FROM shelter
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper());
    }

    @Override
    public Optional<Shelter> findById(int shelterId) {
        String sql = """
                SELECT *
                FROM shelter
                WHERE shelter_id=?;
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper(), shelterId).stream().findFirst();
    }

    @Override
    public List<Shelter> findByName(String shelterName) {
        String sql = """
                SELECT *
                FROM shelter
                WHERE LOWER(shelter_name) LIKE LOWER(`%?%`);
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper(), shelterName);
    }

    @Override
    public List<Shelter> findByAddress(String shelterAddress) {
        String sql = """
                SELECT *
                FROM shelter
                WHERE shelter_address LIKE `%?%`;
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper(), shelterAddress);
    }

    @Override
    public List<Shelter> findByPhone(String shelterPhone) {
        String sql = """
                SELECT *
                FROM shelter
                WHERE shelter_phone LIKE `%?%`;
                """;
        return jdbcTemplate.query(sql, new ShelterRowMapper(), shelterPhone);
    }

    @Override
    public int addShelter(Shelter shelter) {
        String sql = """
                INSERT INTO shelter (shelter_name, shelter_address, shelter_phone, shelter_num_adoptions)
                VALUES (?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, shelter.getName(), shelter.getAddress(), shelter.getPhone(),
                shelter.getNumAdoptions());
    }

    @Override
    public int updateShelter(int shelterId, Shelter shelter) {
        String sql = """
                UPDATE shelter
                SET shelter_name=?, shelter_address=?, shelter_phone=?, shelter_num_adoptions=?
                WHERE shelter_id=?;
                """;
        return jdbcTemplate.update(sql, shelter.getName(), shelter.getAddress(), shelter.getPhone(),
                shelter.getNumAdoptions(), shelterId);
    }

    @Override
    public int deleteShelter(int shelterId) {
        String sql = """
                DELETE FROM shelter
                WHERE shelter_id=?;
                """;
        return jdbcTemplate.update(sql, shelterId);
    }

}
