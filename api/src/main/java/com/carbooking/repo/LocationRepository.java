package com.carbooking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findAllByDealerId(String dealerId);
}
