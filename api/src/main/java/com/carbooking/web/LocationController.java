package com.carbooking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.repo.Location;
import com.carbooking.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocation(){
        return locationService.getAllLocations();
    }

    @GetMapping(value = "/{dealerId}")
    public List<Location> getLocation(@PathVariable String dealerId){
        return locationService.getLocationsByDealerId(dealerId);
    }
    
    
}
