package com.eataholic.dao.impl;

import com.eataholic.dao.UserDao;
import com.eataholic.model.Users;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao{
	
	Session session=new Configuration().configure().buildSessionFactory().openSession();  
    Transaction transaction=session.beginTransaction();  
	@Override
	public boolean getUserName(String name) {
		// TODO Auto-generated method stub  
		List<String> list=new ArrayList<String>();
		try{
			list=session.createQuery("select u from Users as u where u.userName like ?").setParameter(0,name).list();		
		}
	    catch(Exception e){
	    	return true;
	    }
		if(list==null)return false;
		else if(list.size()==0)return false;
		else {
			return true;
		}
	}
	
	@Override
	public boolean getUserEmail(String email) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		try{
			list=session.createQuery("select u from Users as u where u.email like ?").setParameter(0,email).list();		
		}
	    catch(Exception e){
	    	return true;
	    }
		System.out.println(list.size());
		if(list==null)return false;
		else if(list.size()==0)return false;
		else {
			return true;
		}
	}

	@Override
	public boolean updateUserInfo(Users user) {
		// TODO Auto-generated method stub
		try{
			session.update(user);
			transaction.commit();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		try{
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public Users getUserInfoByName(String name) {
		// TODO Auto-generated method stub
		Users user=new Users();
		try{
			user=(Users) session.get(Users.class,name);  		
		}
		catch(Exception e){
			
	    }
		return user;
	}

}
