package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import com.team8.petadoptionserver.model.Volunteer;

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