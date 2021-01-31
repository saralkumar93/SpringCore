package com.study.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {
	public static void main(String[] args) {
		
	
		ApplicationContext context=new ClassPathXmlApplicationContext("com/study/di/beans.xml");
		Student student=context.getBean("student",Student.class);
		student.displayStudentInfo();
		
		Student avi=context.getBean("avi",Student.class);
		avi.displayStudentInfo();
	}

}

