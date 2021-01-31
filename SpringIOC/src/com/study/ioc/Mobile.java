package com.study.ioc;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/study/ioc/beans.xml");
		System.out.println("config loaded");
		//Airtel air=(Airtel)context.getBean("airtel");//typecasting 
		//Airtel air=context.getBean("airtel",Airtel.class);
		//air.call();
		//air.data();
		Sim sim=context.getBean("sim",Sim.class);
		sim.call();
		sim.data();
	}

}
