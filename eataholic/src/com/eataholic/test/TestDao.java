package com.eataholic.test;

import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Users;

public class TestDao {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDaoImpl();
		String name="123456";
		if(dao.getUserEmail(name))System.out.println("1");
		else System.out.println("0");
		Users user=new Users();
		user.setUserName("lilili");
		user.setPassCode("qqwwee");
		if(dao.addUser(user))System.out.println("1");
	}

}
