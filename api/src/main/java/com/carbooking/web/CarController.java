package com.carbooking.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.model.CarDto;
import com.carbooking.repo.Car;
import com.carbooking.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	public Car addCar(@Valid @RequestBody CarDto carDto) {
		return carService.addCar(carDto);
	}

	@GetMapping(value = "/registration/{registrationNo}")
	public Car getCar(@PathVariable String registrationNo) {
		return carService.getCar(registrationNo);
	}

	@GetMapping(value = "/dealer/{dealerId}")
	public List<Car> getAllCarByDealerId(@PathVariable String dealerId) {
		return carService.getAllCarByDealerId(dealerId);
	}

	@GetMapping
	public List<Car> getAllCar() {
		return carService.getAllCar();
	}

	@PutMapping
	public void updateCar(@RequestBody CarDto carDto) {
		carService.updateCar(carDto);
	}

	@DeleteMapping(value = "/{registrationNo}")
	public void updateCar(@PathVariable String registrationNo) {
		carService.deleteCar(registrationNo);
	}
}
