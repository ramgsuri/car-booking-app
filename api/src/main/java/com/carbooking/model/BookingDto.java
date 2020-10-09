package com.carbooking.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class BookingDto {

    @UniqueElements
    @NotEmpty(message = "booking id can not be null")
    private long bookingId;

    @UniqueElements
    @NotEmpty(message = "dealer id can not be null")
    private String dealerId;

    @UniqueElements
    @NotEmpty(message = "customer id can not be null")
    private String customerId;

    @UniqueElements
    @NotEmpty(message = "car id can not be null")
    private String carId;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
