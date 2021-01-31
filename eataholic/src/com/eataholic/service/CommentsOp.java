package com.eataholic.service;

import java.util.List;

import com.eataholic.model.Comments;

public interface CommentsOp {
	//get comments by user name
	public List<Comments> getCommentsByName(String name);
	
	//get comments by passage id
	public List<Comments> getCommentsByPassageId(int id);
	
	//delete one comment
	public boolean deleteComment(Comments comment);
	
	//add a new comment
	public boolean addComment(Comments comment);

	//get all comments by id asc
	public List<Comments> getAllCommentsById();

	//get one comment by id
	public Comments getCommentById(int id);
}
