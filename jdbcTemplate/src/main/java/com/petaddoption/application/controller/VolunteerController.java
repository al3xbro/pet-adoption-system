package com.petaddoption.application.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.petaddoption.application.dao.VolunteerDao;
import com.petaddoption.application.model.Volunteer;

import java.util.List;

@RestController
@RequestMapping("api/volunteer")
public class VolunteerController {

    @Autowired
    private final VolunteerDao volunteerDao;

    @Autowired
    public VolunteerController(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    @PostMapping("/")
    public void addVolunteer(@RequestBody Volunteer volunteer) {
        volunteerDao.addVolunteer(volunteer);
    }

    @GetMapping("/")
    public List<Volunteer> findAll() {
        return volunteerDao.findAll();
    }

    @GetMapping("/id/{id}")
    public Volunteer findById(@PathVariable("volunteer_id") int id) {
        return volunteerDao.findById(id)
                .orElseThrow(() -> new RuntimeException("volunteer not found"));
    }

    @PutMapping("/{id}")
    public int updateVolunteer(@Valid @RequestBody Volunteer volunteer, @PathVariable("id") int id) {
        return volunteerDao.updateVolunteer(id, volunteer);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable("volunteer_id") int id) {
        volunteerDao.deleteVolunteer(id);
    }
}