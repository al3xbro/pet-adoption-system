package com.twilio.jdbcTemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.validation.constraints.NotBlank;

public class Volunteer {

   @JsonProperty("volunteer_id")
   private int volunteer_id;

  // @NotBlank
   @JsonProperty("volunteer_name")
   private String name;

   //@NotBlank
   @JsonProperty("hours_worked")
   private int hoursWorked;

public Volunteer(int volunteer_id, String name, int hoursWorked) {
        this.volunteer_id = volunteer_id;
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public int getID() {
        return volunteer_id;
    }

    public void setID(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public String toString() {
        return "Volunteer{" +
                "ID='" + volunteer_id + '\'' +
                ", name='" + name + '\'' +
                ", hoursWorked='" + hoursWorked + '\'' +
                '}';
    }

}