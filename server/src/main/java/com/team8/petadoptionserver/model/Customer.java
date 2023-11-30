package com.team8.petadoptionserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty
    private int customerId;

    @JsonProperty
    private String customerFirstName;

    @JsonProperty
    private String customerLastName;

    @JsonProperty
    private String customerAddress;

    @JsonProperty
    private String customerPhone;

    @JsonProperty
    private String img;

    public Customer(int customerId, String customerFirstName, String customerLastName, 
            String customerAddress, String customerPhone, String img) {
                this.customerId = customerId;
                this.customerFirstName = customerFirstName;
                this.customerLastName = customerLastName;
                this.customerAddress = customerAddress;
                this.customerPhone = customerPhone;
                this.img = img;
    }

    public int getId() {
        return customerId;
    }

    public void setId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return customerFirstName;
    }

    public void setFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getLastName() {
        return customerLastName;
    }

    public void setLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getAddress() {
        return customerAddress;
    }

    public void setAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhone() {
        return customerPhone;
    }

    public void setPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId='" + customerId + "', " + "customerFirstName='" + customerFirstName + "', "
                + "customerLastName='" + customerLastName + "', " + "customerAddress='" + customerAddress + "', "
                + "customerPhone='" + customerPhone + "', " + "customerImg='" + img + "'" + "}";
    }
}