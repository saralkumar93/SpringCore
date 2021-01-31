package com.eataholic.service;

import com.eataholic.model.Users;

public interface UserSignIn {
	//check user's identity,IF right THEN log in
	public boolean checkIdentity(Users user);
}
