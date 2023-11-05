package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Volunteer;

@Repository
public interface VolunteerDAOInt {

    // get

    List<Volunteer> findAll();

    Optional<Volunteer> findById(int volunteerId);

    List<Volunteer> findByName(String volunteerName);

    List<Volunteer> findByShelter(int shelterId);

    // post

    int addVolunteer(Volunteer volunteer);

    // put

    int updateVolunteer(int volunteerId, Volunteer volunteer);

    // delete

    int deleteVolunteer(int volunteerId);

}