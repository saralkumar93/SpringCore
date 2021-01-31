package com.eataholic.test;

import java.util.*;  

import org.hibernate.*;  
import org.hibernate.cfg.*;
import com.eataholic.model.Users;  

public class TestHibernate {
	/*public static void main(String[] args) {  
        //��������ν�Ľ�������  
        Session session=new Configuration().configure().buildSessionFactory().openSession();  
        Transaction transaction=session.beginTransaction();  
        Users users=new Users();  
        List<Users> list = new ArrayList<Users>();  
        System.out.println("��ʱ��Users��");  
        list=session.createQuery("from Users").list();  
        for(int i=0;i<list.size();i++){  
            System.out.println(list.get(i).getId()+list.get(i).getUserName());  
            System.out.println(list.get(i).getPassCode());  
        }  
        /*users=new Users();
        users.setUserName("123456");
        users.setPassCode("123dd");
        session.save(users);  
        transaction.commit();
        System.out.println("��ʱ��Testtable��");  
        list=session.createQuery("from Users").list();  
        for(int i=0;i<list.size();i++){  
        	System.out.println(list.get(i).getId()+list.get(i).getUserName());  
            System.out.println(list.get(i).getPassCode());  
        } 
		
	}*/
}
