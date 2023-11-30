package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team8.petadoptionserver.dao.PetDAO;
import com.team8.petadoptionserver.model.Pet;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetDAO petDAO;

    @Autowired
    public PetController(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    @GetMapping({ "", "/" })
    public List<Pet> findAll() {
        return petDAO.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Pet> findById(@PathVariable("id") int id) {
        return petDAO.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Pet> findByName(@PathVariable("name") String name) {
        return petDAO.findByName(name);
    }

    @GetMapping("/age/{age}")
    public List<Pet> findByAge(@PathVariable("age") int age) {
        return petDAO.findByAge(age);
    }

    @GetMapping("/species/{species}")
    public List<Pet> findBySpecies(@PathVariable("species") String species) {
        return petDAO.findBySpecies(species);
    }

    @GetMapping("/breed/{breed}")
    public List<Pet> findByBreed(@PathVariable("breed") String breed) {
        return petDAO.findByBreed(breed);
    }

    @PostMapping({ "", "/" })
    public int addPet(@RequestBody Pet pet) {
        return petDAO.addPet(pet);
    }

    @PutMapping("/update/{id}")
    public int updatePet(@PathVariable("id") int id, @RequestBody Pet pet) {
        return petDAO.updatePet(id, pet);
    }

    @GetMapping("/delete/{id}")
    public int deletePet(@PathVariable("id") int id) {
        return petDAO.deletePet(id);
    }
}