package com.petaddoption.application.dao;

import java.util.List;
import java.util.Optional;

import com.petaddoption.application.model.Volunteer;

public interface VolunteerDao {
    List<Volunteer> findAll();

    int addVolunteer(Volunteer volunteer);

    Optional<Volunteer> findById(int id);

    int deleteVolunteer(int id);

    int updateVolunteer(int id, Volunteer volunteer);

    List<Volunteer> findByName(String name);
}