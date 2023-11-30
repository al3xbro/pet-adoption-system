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

    @JsonProperty
    private String img;

    public Pet(int petId, String petName, int petAge, 
            String petSpecies, String petBreed, String img) {
                this.petId = petId;
                this.petName = petName;
                this.petAge = petAge;
                this.petSpecies = petSpecies;
                this.petBreed = petBreed;
                this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Pet{" + "petId='" + petId + "', " + "petName='" + petName + "', "
                + "petAge='" + petAge + "', " + "petSpecies='" + petSpecies + "', "
                + "petBreed='" + petBreed + "', " + "petImg='" + img + "'" + "}";
    }
}