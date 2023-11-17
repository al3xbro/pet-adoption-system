package com.team8.petadoptionserver.dao;

import com.team8.petadoptionserver.model.Pet;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface PetDAOInt {
    List<Pet> findAll();
    Optional<Pet> findById(int id);
    List<Pet> findByName(String petName);
    List<Pet> findByAge(int petAge);
    List<Pet> findBySpecies(String petSpecies);
    List<Pet> findByBreed(String petBreed);

    int addPet(Pet pet);

    int updatePet(int petId, Pet pet);

    int deletePet(int petId);
}