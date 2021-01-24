package com.sda.carsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.carsales.models.VehicleMovement;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
