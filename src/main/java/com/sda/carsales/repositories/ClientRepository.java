package com.sda.carsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.carsales.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
