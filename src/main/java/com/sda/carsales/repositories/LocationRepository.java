package com.sda.carsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.carsales.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
