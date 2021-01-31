package com.eataholic.service;

import com.eataholic.model.Users;

public interface UserOp {
	//update user information,only used by self
	public boolean updateUserInfo(Users uesr);
	
	//get Users information
	public Users getUsersInfo(String userName);
}
