package com.carbooking.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CustomerDto {

    @UniqueElements
    private String customerId;

    @NotEmpty(message = "first name must not be empty")
    private String name;

    @NotEmpty(message = "contact number must not be empty")
    private String contactNo;

    @Email(message = "email should be a valid email")
    private String emailAddress;

    private LocationDto locationDto;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }
}
