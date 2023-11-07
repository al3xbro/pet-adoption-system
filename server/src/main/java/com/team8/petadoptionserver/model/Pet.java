package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
    @JsonProperty
    private int petId;

    @JsonProperty
    private String petName;

    @JsonProperty
    private int petAge;

    @JsonProperty
    private String petSpecies;

    @JsonProperty
    private String petBreed;

    public Pet(int petId, String petName, int petAge, 
            String petSpecies, String petBreed) {
                this.petId = petId;
                this.petName = petName;
                this.petAge = petAge;
                this.petSpecies = petSpecies;
                this.petBreed = petBreed;
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

    public int getAge() {
        return petAge;
    }

    public void setAge(int petAge) {
        this.petAge = petAge;
    }

    public String getSpecies() {
        return petSpecies;
    }

    public void setSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public String getBreed() {
        return petBreed;
    }

    public void setBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    @Override
    public String toString() {
        return "Pet{" + "petId='" + petId + "', " + "petName='" + petName + "', "
                + "petAge='" + petAge + "', " + "petSpecies='" + petSpecies + "', "
                + "petBreed='" + petBreed + "'" + "}";
    }
}