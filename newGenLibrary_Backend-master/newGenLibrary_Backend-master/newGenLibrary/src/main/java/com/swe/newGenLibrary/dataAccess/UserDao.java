package com.swe.newGenLibrary.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.swe.newGenLibrary.entities.User;


@Repository
@Component
public interface UserDao extends JpaRepository<User, Integer>{
	User getByEmail(String email);
		
	User findFirstByEmail(String email);
	
	boolean existsByEmail(String Email);

	
}
