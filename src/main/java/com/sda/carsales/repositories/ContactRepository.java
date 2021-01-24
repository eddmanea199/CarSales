package com.sda.carsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.carsales.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
