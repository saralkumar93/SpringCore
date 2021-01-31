package com.eataholic.dao;

import java.util.List;

import com.eataholic.model.Comments;

public interface CommentsDao {
	//add new comment into DB
	public boolean addComment(Comments comment);
	
	//delete comment from DB,only used by self
	public boolean deleteComment(Comments comment);
	
	//get comments by belonged passage_id
	public List<Comments> getCommentByPassage(int passage_id);
	
	//get comments by belonged user name
	public List<Comments> getCommentByUser(String userName);

	//get all comments by id asc
	public List<Comments> getAllCommentById();

	//get one comment by id
	public Comments getCommentById(int id);
}
