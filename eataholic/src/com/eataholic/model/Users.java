package com.eataholic.model;

import javax.persistence.*; 

@Entity  
@Table(name="Users")  
public class Users {
	private String userName;//用户名
	private String passCode;//密码
	private String email;//邮箱
	private String description;//简介
	private String profil;//头像
	private String gender;//性别
	
	@Id
	@Column(name = "userName")  
	public String getUserName(){  
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	@Column(name = "passCode")  
	public String getPassCode(){
		return passCode;
	}
	public void setPassCode(String passCode){
		this.passCode=passCode;
	}
	@Column(name = "email")  
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	@Column(name = "description") 
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description=description;
	}
	@Column(name = "profil") 
	public String getProfil(){
		return profil;
	}
	public void setProfil(String profil){
		this.profil=profil;
	}
	@Column(name = "gender") 
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	
}
