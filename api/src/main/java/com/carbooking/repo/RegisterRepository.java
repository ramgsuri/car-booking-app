package com.carbooking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long> {
    Register findByUsername(String username);
}