package com.team8.petadoptionserver.model;

public class Volunteer {

    private int volunteerId;
    private String volunteerFirstName;
    private String volunteerLastName;
    private int volunteerHoursWorked;

    public Volunteer(int volunteerId, String volunteerFirstName, String volunteerLastName, int volunteerHoursWorked) {
        this.volunteerId = volunteerId;
        this.volunteerFirstName = volunteerFirstName;
        this.volunteerLastName = volunteerLastName;
        this.volunteerHoursWorked = volunteerHoursWorked;
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

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId='" + volunteerId + "', " +
                "volunteerFirstName='" + volunteerFirstName + "', " +
                "volunteerLastName='" + volunteerLastName + "', " +
                "volunteerHoursWorked='" + volunteerHoursWorked + "'" +
                "}";
    }
}
