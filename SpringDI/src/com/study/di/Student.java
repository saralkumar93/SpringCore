package com.study.di;

public class Student {
	private String studentName;
	private int id;
	
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setId(int id) {
		this.id = id;
	}
	void displayStudentInfo() {
		System.out.println("name of the student "  +  studentName + "and id " +id);
	}
	

}
