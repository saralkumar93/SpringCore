package com.eataholic.model;

import java.sql.Timestamp;

import javax.persistence.*; 

@Entity  
@Table(name="passage")  
public class Passage {
	private int id;
	private String author;
	private String content;
	private int click;
	private int commentNum;
	private int likeNum;
	private Timestamp passageTime;
	private String title;
	private String passageType;
	private String photo;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "content") 
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "click") 
	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}
	@Column(name = "commentNum") 
	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	@Column(name = "likeNum") 
	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	@Column(name = "passageTime") 
	public Timestamp getPassageTime() {
		return passageTime;
	}

	public void setPassageTime(Timestamp passageTime) {
		this.passageTime = passageTime;
	}
	@Column(name = "title") 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "passageType") 
	public String getPassageType() {
		return passageType;
	}

	public void setPassageType(String passageType) {
		this.passageType = passageType;
	}
	@Column(name = "photo") 
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
