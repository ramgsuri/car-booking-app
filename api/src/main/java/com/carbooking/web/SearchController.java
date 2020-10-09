package com.carbooking.web;

import com.carbooking.model.SearchCarDto;
import com.carbooking.repo.Car;
import com.carbooking.service.SearchCarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchCarService searchCarService;

    @PostMapping
    public List<Car> getSearchCar(@RequestBody SearchCarDto searchCarDto){
        return searchCarService.getSearchedCars(searchCarDto);
    }
}
