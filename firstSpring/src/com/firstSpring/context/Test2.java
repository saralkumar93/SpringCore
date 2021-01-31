package com.firstSpring.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test2 {
public static void main(String[] args) {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	Student1 student=(Student1)context.getBean("studentbean");
	student.displayInfo();
}
}
