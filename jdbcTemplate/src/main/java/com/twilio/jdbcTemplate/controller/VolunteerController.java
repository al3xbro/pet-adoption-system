package com.twilio.jdbcTemplate.controller;

import com.twilio.jdbcTemplate.dao.VolunteerDao;
import com.twilio.jdbcTemplate.model.Volunteer;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Volunteer")
public class VolunteerController {
   private final VolunteerDao volunteerDao;

   @Autowired
   public VolunteerController(VolunteerDao volunteerDao) {
       this.volunteerDao = volunteerDao;
   }

   @PostMapping("/add")
public void addVolunteer(@RequestBody Volunteer volunteer){
   volunteerDao.addVolunteer(volunteer);
}

@GetMapping("/all")
public List<Volunteer> findAll(){
   return volunteerDao.findAll();
}

@GetMapping("/{id}")
public Volunteer findById(@PathVariable("id") int id){
   return volunteerDao.findById(id)
           .orElseThrow(() -> new RuntimeException("volunteer not found"));
}

@PutMapping("/update/{id}")
public int updateVolunteer(@Valid @RequestBody Volunteer volunteer, @PathVariable("id") int id){
   return volunteerDao.updateVolunteer(id,volunteer);
}

@GetMapping("/delete/{id}")
public void deleteVolunteer(@PathVariable("id") int id){
    volunteerDao.deleteVolunteer(id);
}
}