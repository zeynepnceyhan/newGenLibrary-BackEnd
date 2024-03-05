package com.swe.newGenLibrary.business.concretes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swe.newGenLibrary.dataAccess.UserDao;
import com.swe.newGenLibrary.entities.User;



@Service
public class UserDetailsManager implements UserDetailsService{
	
	private UserDao userDao;

	@Autowired
	public UserDetailsManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Async
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//Write Logic to get the user from the DB
        User user = userDao.findFirstByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
