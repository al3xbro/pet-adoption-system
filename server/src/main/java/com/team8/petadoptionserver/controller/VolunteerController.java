package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team8.petadoptionserver.dao.VolunteerDAO;
import com.team8.petadoptionserver.model.Volunteer;
import com.team8.petadoptionserver.model.Shelter;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    public final VolunteerDAO volunteerDAO;

    /*
     * Volunteer {
     * id,
     * firstName,
     * lastName,
     * hoursWorked,
     * img,
     * shelter will be added
     * }
     */

    @Autowired
    public VolunteerController(VolunteerDAO volunteerDAO) {
        this.volunteerDAO = volunteerDAO;
    }

    @GetMapping({ "", "/" })
    public List<Volunteer> findAll() {
        return volunteerDAO.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Volunteer> findById(@PathVariable("id") int id) {
        return volunteerDAO.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Volunteer> findByName(@PathVariable("name") String name) {
        return volunteerDAO.findByName(name);
    }

    @GetMapping("/shelter/{shelter}")
    public List<Volunteer> findByShelter(@PathVariable("shelter") int id) {
        return volunteerDAO.findByShelter(id);
    }

    @GetMapping("/shelter/{volunteerId}")
    public List<Shelter> findShelterForVolunteer(@PathVariable("volunteerId") int volunteerId) {
        return volunteerDAO.findShelterForVolunteer(volunteerId);
    }

    @PostMapping({ "", "/" })
    public int addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerDAO.addVolunteer(volunteer);
    }

    @PutMapping("update/{id}")
    public int updateVolunteer(@PathVariable("id") int id, @RequestBody Volunteer volunteer) {
        return volunteerDAO.updateVolunteer(id, volunteer);
    }

    @GetMapping("/delete/{id}")
    public int deleteVolunteer(@PathVariable("id") int id) {
        return volunteerDAO.deleteVolunteer(id);
    }

}
