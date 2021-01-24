package com.sda.carsales.repositories;

import com.sda.carsales.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	//User findByFirstnameAndLastname(String firstname, String lastname);
}
