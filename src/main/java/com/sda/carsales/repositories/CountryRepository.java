package com.sda.carsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.carsales.models.Country;

@Repository

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
