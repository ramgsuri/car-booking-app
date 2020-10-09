package com.carbooking.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;

public class LocationDto {

    private Long id;
    @NotEmpty(message = "street can not be null")
    private String street;

    @NotEmpty(message = "flat no can not be null")
    private String flatNo;

    @NotEmpty(message = "city can not be null")
    private String city;

    @NotEmpty(message = "country can not be null")
    private String country;

    @NotEmpty(message = "pinCode can not be null")
    private String pinCode;

    @NotEmpty(message = "customer id can not be null")
    @UniqueElements
    private String customerId;

    @NotEmpty(message = "dealer id can not be null")
    @UniqueElements
    private String dealerId;

    @NotEmpty(message = "car id can not be null")
    @UniqueElements
    private String carId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

}
