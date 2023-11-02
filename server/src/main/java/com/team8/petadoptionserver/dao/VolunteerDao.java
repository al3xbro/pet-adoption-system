package com.team8.petadoptionserver.dao;

import java.util.List;
import java.util.Optional;

import com.team8.petadoptionserver.model.Volunteer;

public interface VolunteerDao {
    List<Volunteer> findAll();

    int addVolunteer(Volunteer volunteer);

    Optional<Volunteer> findById(int id);

    int deleteVolunteer(int id);

    int updateVolunteer(int id, Volunteer volunteer);

    List<Volunteer> findByName(String name);

    List<Volunteer> findByHoursWorked(int hoursWorked);
}