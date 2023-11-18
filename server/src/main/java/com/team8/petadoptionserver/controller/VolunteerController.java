package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team8.petadoptionserver.dao.VolunteerDAO;
import com.team8.petadoptionserver.model.Volunteer;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {

    public final VolunteerDAO volunteerDAO;

    @Autowired
    public VolunteerController(VolunteerDAO volunteerDAO) {
        this.volunteerDAO = volunteerDAO;
    }

    @GetMapping({ "", "/" })
    public List<Volunteer> getAll() {
        return volunteerDAO.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Volunteer> getById(@PathVariable("id") int id) {
        return volunteerDAO.findById(id);
    }

    @PostMapping({ "", "/" })
    public int addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerDAO.addVolunteer(volunteer);
    }

    @GetMapping("/delet/{id}")
    public int deleteVolunteer(@PathVariable("id") int id) {
        return volunteerDAO.deleteVolunteer(id);
    }

}
