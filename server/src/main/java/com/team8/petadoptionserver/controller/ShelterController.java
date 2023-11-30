package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team8.petadoptionserver.dao.ShelterDAO;
import com.team8.petadoptionserver.model.Shelter;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    public final ShelterDAO shelterDAO;

    @Autowired
    public ShelterController(ShelterDAO shelterDAO) {
        this.shelterDAO = shelterDAO;
    }

    @PostMapping({ "", "/" })
    public int addShelter(@RequestBody Shelter shelter) {
        return shelterDAO.addShelter(shelter);
    }

    @GetMapping({ "", "/" })
    public List<Shelter> findAll() {
        return shelterDAO.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Shelter> findById(@PathVariable("id") int id) {
        return shelterDAO.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Shelter> findByName(@PathVariable("name") String name) {
        return shelterDAO.findByName(name);
    }

    @PutMapping("/update/{id}")
    public int updateShelter(@PathVariable("id") int id, @RequestBody Shelter shelter) {
        return shelterDAO.updateShelter(id, shelter);
    }

    @GetMapping("/delete/{id}")
    public int deleteShelter(@PathVariable("id") int id) {
        return shelterDAO.deleteShelter(id);
    }
}