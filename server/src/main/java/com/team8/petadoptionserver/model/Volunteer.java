package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Volunteer {

    @JsonProperty("volunteer_id")
    private int volunteerId;

    @JsonProperty("volunteer_first_name")
    private String volunteerFirstName;

    @JsonProperty("volunteer_last_name")
    private String volunteerLastName;

    @JsonProperty("volunteer_hours_worked")
    private int volunteerHoursWorked;

    @JsonProperty
    private String img;

    public Volunteer(int volunteerId, String volunteerFirstName, String volunteerLastName, int volunteerHoursWorked, String img) {
        this.volunteerId = volunteerId;
        this.volunteerFirstName = volunteerFirstName;
        this.volunteerLastName = volunteerLastName;
        this.volunteerHoursWorked = volunteerHoursWorked;
        this.img = img;
    }

    public int getId() {
        return volunteerId;
    }

    public void setId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getFirstName() {
        return volunteerFirstName;
    }

    public void setFirstName(String volunteerFirstName) {
        this.volunteerFirstName = volunteerFirstName;
    }

    public String getLastName() {
        return volunteerLastName;
    }

    public void setLastName(String volunteerLastName) {
        this.volunteerLastName = volunteerLastName;
    }

    public int getHoursWorked() {
        return volunteerHoursWorked;
    }

    public void setHoursWorked(int volunteerHoursWorked) {
        this.volunteerHoursWorked = volunteerHoursWorked;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId='" + volunteerId + "', " +
                "volunteerFirstName='" + volunteerFirstName + "', " +
                "volunteerLastName='" + volunteerLastName + "', " +
                "volunteerHoursWorked='" + volunteerHoursWorked + "', " +
                "volunteerImg='" + img + "'" +
                "}";
    }
}
