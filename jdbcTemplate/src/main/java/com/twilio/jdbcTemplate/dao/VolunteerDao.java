package com.twilio.jdbcTemplate.dao;

import com.twilio.jdbcTemplate.model.Volunteer;

import java.util.List;
import java.util.Optional;

public interface VolunteerDao {
   List<Volunteer> findAll();
   int addVolunteer(Volunteer volunteer);
   Optional<Volunteer> findById(int id);
   int deleteVolunteer(int id);
   int updateVolunteer(int id, Volunteer volunteer);
}