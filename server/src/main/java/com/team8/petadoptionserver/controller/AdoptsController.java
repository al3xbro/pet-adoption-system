package com.team8.petadoptionserver.controller;

import com.team8.petadoptionserver.dao.AdoptsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/logs")
public class AdoptsController {
    private final AdoptsDAO adoptsDAO;

    @Autowired
    public AdoptsController(AdoptsDAO adoptsDAO) {
        this.adoptsDAO = adoptsDAO;
    }

    @GetMapping({ "", "/" })
    public List<Map<String, Object>> findAll() {
        return adoptsDAO.findAll();
    }

    @PostMapping({ "", "/" })
    public int addAdoption(@RequestBody Map<String, Object> adoptionData) {
        int petId = (int) adoptionData.get("pet_id");
        int customerId = (int) adoptionData.get("customer_id");
        int volunteerId = (int) adoptionData.get("volunteer_id");
        int shelterId = (int) adoptionData.get("shelter_id");

        return adoptsDAO.addAdoption(petId,customerId,volunteerId, shelterId);

    }
}
