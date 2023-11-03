package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.team8.petadoptionserver.model.Volunteer;

@Repository
public interface VolunteerDAOInt {

    // get

    List<Volunteer> findAll();

    Optional<Volunteer> findById(int id);

    List<Volunteer> findByName(String name);

    List<Volunteer> findByHoursWorked(int hoursWorked);

    // post

    int addVolunteer(Volunteer volunteer);

    // put

    int updateVolunteer(int id, Volunteer volunteer);

    // delete

    int deleteVolunteer(int id);

}