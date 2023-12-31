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
    private int shelterId;

    @JsonProperty
    private String petBreed;

    @JsonProperty
    private String petSex;

    @JsonProperty
    private String img;

    public Pet(int petId, String petName, int petAge, int shelterId,
            String petSpecies, String petBreed, String petSex, String img) {
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
        this.shelterId = shelterId;
        this.petSpecies = petSpecies;
        this.petBreed = petBreed;
        this.petSex = petSex;
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

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
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

    public String getSex() {
        return petSex;
    }

    public void setSex(String petSex) {
        this.petSex = petSex;
    }

    @Override
    public String toString() {
        return "Pet{" + "petId='" + petId + "', " + "petName='" + petName + "', "
                + "petAge='" + petAge + "', " + "petSpecies='" + petSpecies + "', "
                + "petBreed='" + petBreed + "', " + "petSex='" + petSex + "', "
                + "petImg='" + img + "'" + "}";
    }
}