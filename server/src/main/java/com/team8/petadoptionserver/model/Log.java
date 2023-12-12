package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Log {
    @JsonProperty
    private int logId;

    @JsonProperty
    private String petName;

    @JsonProperty
    private String customerName;

    @JsonProperty
    private String volunteerName;

    @JsonProperty
    private String shelterName;

    public Log(String petName, String customerName, String volunteerName, String shelterName) {
        this.petName = petName;
        this.customerName = customerName;
        this.volunteerName = volunteerName;
        this.shelterName = shelterName;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    @Override
    public String toString() {
        return "Log [customerName=" + customerName + ", petName=" + petName + ", shelterName=" + shelterName
                + ", volunteerName=" + volunteerName + "]";
    }
}
