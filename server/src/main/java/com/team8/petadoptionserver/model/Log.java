package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Log {
    @JsonProperty
    private int petId;

    @JsonProperty
    private int customerId;

    @JsonProperty
    private int volunteerId;

    @JsonProperty
    private int shelterId;

    public Log(int petId, int customerId, int volunteerId, int shelterId) {
        this.petId = petId;
        this.customerId = customerId;
        this.volunteerId = volunteerId;
        this.shelterId = shelterId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    @Override
    public String toString() {
        return "{" + " petId='" + getPetId() + "'" + ", customerId='" + getCustomerId() + "'" + ", volunteerId='"
                + getVolunteerId() + "'" + ", shelterId='" + getShelterId() + "'" + "}";
    }
}
