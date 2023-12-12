package com.team8.petadoptionserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team8.petadoptionserver.dao.PetDAO;
import com.team8.petadoptionserver.model.Pet;
import com.team8.petadoptionserver.model.Shelter;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    /*
     * Pet {
     * "id",
     * "name",
     * "age",
     * "species",
     * "breed",
     * "desc",
     * "img",
     * "shelter will be added"
     * }
     */

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

    @GetMapping("/shelter/{petId}")
    public List<Shelter> findShelterForPet(@PathVariable("petId") int petId) {
        return petDAO.findShelterForPet(petId);
    }

    @PostMapping({ "", "/" })
    public int addPet(@RequestBody Pet pet) {
        return petDAO.addPet(pet);
    }

    @PutMapping("/update/{id}")
    public int updatePet(@PathVariable("id") int id, @RequestBody Pet pet) {
        return petDAO.updatePet(id, pet);
    }

    @PostMapping("/delete/{id}")
    public int deletePet(@PathVariable("id") int id) {
        return petDAO.deletePet(id);
    }

    @GetMapping("/available/{name}")
    public List<Pet> findAvailablePets(@PathVariable("name") String name) {
        return petDAO.getAvailablePets(name);
    }

    @GetMapping("/available/")
    public List<Pet> findAvailablePets() {
        return petDAO.getAvailablePets("");
    }
}