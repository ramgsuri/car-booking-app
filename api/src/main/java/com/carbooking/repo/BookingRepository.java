package com.carbooking.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	List<Booking> findAllByCustomerId(String custId);

	List<Booking> findAllByDealerId(String dealerId);
}
