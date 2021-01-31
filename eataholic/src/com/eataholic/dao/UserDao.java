package com.eataholic.dao;

import java.util.List;

import com.eataholic.model.Users;

public interface UserDao {
	//get the number of one user name from DB
	public boolean getUserName(String name);
	
	//get the number of one user email from DB
	public boolean getUserEmail(String email);
	
	//get one user's info by name
	public Users getUserInfoByName(String name);
	
	//update one user's info
	public boolean updateUserInfo(Users user);
	
	//add one user into DB
	public boolean addUser(Users user);
}
