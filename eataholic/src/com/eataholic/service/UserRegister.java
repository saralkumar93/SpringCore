package com.eataholic.service;

import com.eataholic.model.Users;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface UserRegister {
	//check user name, IF exist THEN false 
	public boolean checkUserName(String name);
	
	//check user email, IF exist THEN false
	public boolean checkUserEmail(String email);
	
	//add new user into DB, IF fail THEN false
	public int addUser(Users user);
}