package com.eataholic.service.impl;

import java.util.List;

import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Users;
import com.eataholic.service.UserRegister;

public class UserRegisterImpl implements UserRegister {

	UserDao userdao=new UserDaoImpl();
	
	@Override
	public boolean checkUserName(String name) {
		// TODO Auto-generated method stub
		if(userdao.getUserName(name)==true)return true;
		else return false;
	}

	@Override
	public boolean checkUserEmail(String email) {
		// TODO Auto-generated method stub
		if(userdao.getUserEmail(email)==true)return true;
		else return false;
	}

	@Override
	public int addUser(Users user) {
		// TODO Auto-generated method stub
		String tmp=user.getUserName();
		if(checkUserName(tmp)==true)return -1;	
		tmp=user.getEmail();
		System.out.println(tmp);
		if(checkUserEmail(tmp)==true)return -2;
		try{
			userdao.addUser(user);
		}
		catch(Exception e){
			return 0;
		}
		return 1;
	}

}
