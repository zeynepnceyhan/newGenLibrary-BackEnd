package com.swe.newGenLibrary.business.abstracts;

import com.swe.newGenLibrary.core.utulitites.result.Result;
import com.swe.newGenLibrary.entities.SignupDto;

public interface AuthService {
	 Result createUser(SignupDto signupDto);
}
