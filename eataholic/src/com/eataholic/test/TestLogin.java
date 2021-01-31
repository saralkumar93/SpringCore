package com.eataholic.test;

import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Users;

public class TestLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userdao=new UserDaoImpl();
		// TODO Auto-generated method stub
		Users tmp=new Users();
		String name="我是一条咸鱼";
		
		tmp=userdao.getUserInfoByName(name);
		if(tmp!=null)
		System.out.println(tmp.getPassCode());
		if(tmp!=null&&tmp.getPassCode().equals("123456"))System.out.println("y");
		else System.out.println("n");
	}

}
