package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Pet;
import com.team8.petadoptionserver.model.PetRowMapper;

@Repository
public class PetDAO implements PetDAOInt {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
   public List<Pet> findAll() {
        String sql = """
                SELECT * 
                FROM pet
                LIMIT 100
                """;
        
        return jdbcTemplate.query(sql, new PetRowMapper);
   }

    @Override
    public Optional<Pet> findById(int petId) {
        String sql = """
                SELECT *
                FROM pet
                WHERE pet_id=?;
                """;

        return jdbcTemplate.query(sql, new PetRowMapper(), PetId).stream().findFirst();
    }

    @Override
    public List<Pet> findByName(String petName) {
        String sql = """
                SELECT *
                FROM pet
                WHERE pet_name=?;
                """;

        return jdbcTemplate.query(sql, new PetRowMapper(), petName);
    }

    @Override
    public List<Pet> findByAge(int petAge) {
        String sql = """
            SELECT *
            FROM pet
            WHERE pet_age = ?;
            """;

        return jdbcTemplate.query(sql, new PetRowMapper(), petAge);
    }

    @Override
    public List<Pet> findBySpecies(String petSpecies) {
        String sql = """
            SELECT *
            FROM pet
            WHERE pet_species = ?;
            """;

        return jdbcTemplate.query(sql, new PetRowMapper(), petSpecies);
    }

    @Override
    public List<Pet> findByBreed(String petBreed) {
        String sql = """
            SELECT *
            FROM pet
            WHERE pet_breed = ?;
            """;

        return jdbcTemplate.query(sql, new PetRowMapper(), petBreed);
    }

    @Override
    public int addPet(Pet pet) {
        String sql = """
            INSERT INTO pet (pet_name, pet_age, pet_species, pet_breed)
            VALUES (?, ?, ?, ?);
            """;

        return jdbcTemplate.update(sql, pet.getPetName(), pet.getAge(), pet.getSpecies(), pet.getBreed());
    }

    @Override
    public int updatePet(int petId, Pet pet) {
        String sql = """
            UPDATE pet
            SET pet_name = ?, pet_age = ?, pet_species = ?, pet_breed = ?
            WHERE pet_id = ?;
            """;

        return jdbcTemplate.update(sql, pet.getPetName(), pet.getAge(), pet.getSpecies(), pet.getBreed(), pet.getPetId());
    }

    @Override
    public int deletePet(int petId) {
        String sql = """
            DELETE FROM pet
            WHERE pet_id = ?;
            """;

        return jdbcTemplate.update(sql, petId);
    }
}