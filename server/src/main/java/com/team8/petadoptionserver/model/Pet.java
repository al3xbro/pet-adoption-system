package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class Pet {
    @NotBlank
    @JsonProperty("pet_id")
    private int petId;

    @NotBlank
    @JsonProperty("pet_name")
    private String petName;

    @NotBlank
    @JsonProperty("pet_age")
    private int petAge;

    public Pet(int petId, String petName, int petAge) {
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
    }

    public int getId() {
        return petId;
    }

    public void setId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return petName;
    }

    public void setName(String petName) {
        this.petName = petName;
    }

    public int getHoursWorked() {
        return petAge;
    }

    public void setHoursWorked(int petAge) {
        this.petAge = petAge;
    }

    @Override
    public String toString() {
        return "Pet(" +
                "petId='" + petId + "', " +
                "petName='" + petName + "', " +
                "petAge='" + petAge + "'" +
                ")";
    }
}