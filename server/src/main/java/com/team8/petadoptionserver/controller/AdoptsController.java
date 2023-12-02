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
}
