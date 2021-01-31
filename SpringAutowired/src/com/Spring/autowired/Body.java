package com.Spring.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/Spring/autowired/beans.xml");
		Human human=context.getBean("human",Human.class);
		human.StartPumping();
	}

}
