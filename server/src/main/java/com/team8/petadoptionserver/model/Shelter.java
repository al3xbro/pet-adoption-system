package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shelter {
    @JsonProperty
    private int shelterId;

    @JsonProperty
    private String shelterName;

    @JsonProperty
    private String shelterAddress;

    @JsonProperty
    private String shelterPhone;

    @JsonProperty
    private int shelterNumAdoptions;

    @JsonProperty
    private String img;

    public Shelter(int shelterId, String shelterName, String shelterAddress, String shelterPhone,
            int shelterNumAdoptions, String img) {
        this.shelterId = shelterId;
        this.shelterName = shelterName;
        this.shelterAddress = shelterAddress;
        this.shelterPhone = shelterPhone;
        this.shelterNumAdoptions = shelterNumAdoptions;
        this.img = img;
    }

    public int getId() {
        return shelterId;
    }

    public void setId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getName() {
        return shelterName;
    }

    public void setName(String shelterName) {
        this.shelterName = shelterName;
    }

    public String getAddress() {
        return shelterAddress;
    }

    public void setAddress(String shelterAddress) {
        this.shelterAddress = shelterAddress;
    }

    public String getPhone() {
        return shelterPhone;
    }

    public void setPhone(String shelterPhone) {
        this.shelterPhone = shelterPhone;
    }

    public int getNumAdoptions() {
        return shelterNumAdoptions;
    }

    public void setNumAdoptions(int shelterNumAdoptions) {
        this.shelterNumAdoptions = shelterNumAdoptions;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Shelter{" + "shelterId='" + shelterId + "', " + "shelterName='" + shelterName + "', "
                + "shelterAddress='" + shelterAddress + "', " + "shelterPhone='" + shelterPhone + "', "
                + "shelterNumAdoptions='" + shelterNumAdoptions + "', " + "shelterImg='" + img +  "'" + "}";
    }

}
