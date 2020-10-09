package com.carbooking.model;

import javax.validation.constraints.NotEmpty;

public class SearchCarDto {

    @NotEmpty(message = "car brand can not be null")
    private String carBrand;

    @NotEmpty(message = "location id can not be null")
    private Long locationId;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

}
