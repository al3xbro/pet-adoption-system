package com.team8.petadoptionserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team8.petadoptionserver.dao.AdoptsDAO;
import com.team8.petadoptionserver.model.Log;

@RestController
@RequestMapping("api/logs")
public class AdoptsController {
    private final AdoptsDAO adoptsDAO;

    @Autowired
    public AdoptsController(AdoptsDAO adoptsDAO) {
        this.adoptsDAO = adoptsDAO;
    }

    @GetMapping({ "", "/" })
    public List<Log> findAll() {
        System.out.println(adoptsDAO.findAll());
        return adoptsDAO.findAll();
    }

    @PostMapping({ "", "/" })
    public int addAdoption(@RequestBody Log adoptionData) {
        return adoptsDAO.addAdoption(adoptionData);
    }
}
