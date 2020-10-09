package com.carbooking.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarDto {

    private String model;

    @NotNull
    private String registrationNo;

    @NotNull
    private String brand;

    @NotNull
    private Double price;

    @NotNull
    private Long locationId;

    @NotNull
    private String dealerId;
    private boolean availability;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
