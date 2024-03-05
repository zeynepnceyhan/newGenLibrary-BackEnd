package com.swe.newGenLibrary.business.concretes;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swe.newGenLibrary.business.abstracts.AuthService;
import com.swe.newGenLibrary.core.utulitites.result.Result;
import com.swe.newGenLibrary.core.utulitites.result.SuccessDataResult;
import com.swe.newGenLibrary.dataAccess.UserDao;
import com.swe.newGenLibrary.entities.SignupDto;
import com.swe.newGenLibrary.entities.User;
import com.swe.newGenLibrary.entities.UserDto;



@Service
public class AuthManager implements AuthService{

	private UserDao userDao;

	@Autowired
	public AuthManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Async
	@Transactional
	@Override
	public Result createUser(SignupDto signupDto) {

	 	User user = new User();
        user.setName(signupDto.getName());
        user.setSurname(signupDto.getSurname());
        user.setEmail(signupDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDto.getPassword()));
        User createdUser = userDao.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setName(createdUser.getName());
        userDto.setSurname(createdUser.getSurname());
        return new SuccessDataResult<UserDto>(userDto,"User created Successfuly");
	}
}
