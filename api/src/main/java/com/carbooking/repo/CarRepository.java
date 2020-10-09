package com.carbooking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
	
    Car findByRegistrationNo(String registrationNo);

    List<Car> findByBrandAndLocationId(String carBrand, Long locationId);

	List<Car> findByDealerId(String dealerId);

	void deleteByRegistrationNo(String registrationNo);
}
