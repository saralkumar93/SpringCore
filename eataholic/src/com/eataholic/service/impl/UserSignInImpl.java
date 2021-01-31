package com.eataholic.service.impl;

import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Users;
import com.eataholic.service.UserSignIn;

public class UserSignInImpl implements UserSignIn{
	
	UserDao userdao=new UserDaoImpl();
	@Override
	public boolean checkIdentity(Users user) {
		// TODO Auto-generated method stub
		Users tmp=new Users();
		String name=user.getUserName();
		
		tmp=userdao.getUserInfoByName(name);
		
		if(tmp!=null&&tmp.getPassCode().equals(user.getPassCode()))return true;
		else return false;
	}
}
