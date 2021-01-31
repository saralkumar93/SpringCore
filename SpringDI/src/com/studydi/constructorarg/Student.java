package com.studydi.constructorarg;

public class Student {
	private int id;
	private String studentName;
	
	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
}
	
	void displayStudentInfo() {
		System.out.println("name of the student "  +  studentName + "and id " +id);
	}
	

}
