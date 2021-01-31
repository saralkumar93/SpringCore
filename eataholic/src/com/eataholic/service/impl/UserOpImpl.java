package com.eataholic.service.impl;

import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Users;
import com.eataholic.service.UserOp;

public class UserOpImpl implements UserOp{
	UserDao userdao=new UserDaoImpl();

	@Override
	public boolean updateUserInfo(Users user) {
		if(userdao.addUser(user))return true;
		else return false;
	}

	@Override
	public Users getUsersInfo(String userName) {
		Users user=new Users();
		user=userdao.getUserInfoByName(userName);
		return user;
	}

}
