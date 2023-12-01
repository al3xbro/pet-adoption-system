package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import com.team8.petadoptionserver.model.Shelter;

public interface ShelterDAOInt {

    // get

    List<Shelter> findAll();

    Optional<Shelter> findById(int shelterId);

    List<Shelter> findByName(String shelterName);

    List<Shelter> findByAddress(String shelterAddress);

    List<Shelter> findByPhone(String shelterPhone);

    // post

    int addShelter(Shelter shelter);

    // put

    int updateShelter(int shelterId, Shelter shelter);

    // delete

    int deleteShelter(int shelterId);
}
