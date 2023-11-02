package com.team8.petadoptionserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/volunteer")
public class VolunteerController {

    @GetMapping("/")
    public String getAll() {
        return "volunteer";
    }

    @GetMapping("/id/{id}")
    public String getById() {
        return "volunteer";
    }

}
