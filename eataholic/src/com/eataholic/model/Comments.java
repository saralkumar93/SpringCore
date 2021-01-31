package com.eataholic.model;

import java.sql.Timestamp;

import javax.persistence.*; 

@Entity  
@Table(name="Comments")  
public class Comments {
	private int id;
	private int belong_Passage;
	private String belong_User;
	private String content;
	private Timestamp remarkTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "belong_Passage") 
	public int getBelong_Passage() {
		return belong_Passage;
	}
	public void setBelong_Passage(int belong_Passage) {
		this.belong_Passage = belong_Passage;
	}
	@Column(name = "belong_User") 
	public String getBelong_User() {
		return belong_User;
	}
	public void setBelong_User(String belong_User) {
		this.belong_User = belong_User;
	}
	@Column(name = "content") 
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "remarkTime") 
	public Timestamp getRemarkTime() {
		return remarkTime;
	}
	public void setRemarkTime(Timestamp remarkTime) {
		this.remarkTime = remarkTime;
	}
	
    
}
