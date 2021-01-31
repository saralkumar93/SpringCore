package com.study.atvalue.atrequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/study/atvalue/atrequired/beans.xml");
		Student student=context.getBean("student",Student.class);
		student.getStudentInfo();
		
	}

}
