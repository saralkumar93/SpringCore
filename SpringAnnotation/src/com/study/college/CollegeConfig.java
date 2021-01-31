package com.study.college;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages="com.study.college")
public class CollegeConfig {
	
	public College collegeBean() {
		College college=new College();
		return college;
	}

}
