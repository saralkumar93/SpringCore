package com.studydi.constructorarg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {
	public static void main(String[] args) {
		
	
		ApplicationContext context=new ClassPathXmlApplicationContext("com/studydi/constructorarg/beans2.xml");
		Student student=context.getBean("student1",Student.class);
		student.displayStudentInfo();
		
		
	}

}

