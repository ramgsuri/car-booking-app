package com.carbooking.service;

import com.carbooking.model.SearchCarDto;
import com.carbooking.repo.Car;
import com.carbooking.repo.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getSearchedCars(SearchCarDto searchCarDto) {
        return carRepository.findByBrandAndLocationId(searchCarDto.getCarBrand(), searchCarDto.getLocationId());
    }
}
