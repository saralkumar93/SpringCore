package com.eataholic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.eataholic.dao.CommentsDao;
import com.eataholic.dao.PassageDao;
import com.eataholic.dao.impl.CommentsDaoImpl;
import com.eataholic.dao.impl.PassageDaoImpl;
import com.eataholic.model.Comments;
import com.eataholic.model.Passage;
import com.eataholic.service.CommentsOp;

public class CommentsOpImpl implements CommentsOp{
	CommentsDao commentDao=new CommentsDaoImpl();
	
	@Override
	public List<Comments> getCommentsByName(String name) {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		list=commentDao.getCommentByUser(name);
		return list;
	}

	@Override
	public List<Comments> getCommentsByPassageId(int id) {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		list=commentDao.getCommentByPassage(id);
		return list;
	}

	@Override
	public boolean deleteComment(Comments comment) {
		// TODO Auto-generated method stub
		if(commentDao.deleteComment(comment))return true;
		else return false;
	}

	@Override
	public boolean addComment(Comments comment) {
		// TODO Auto-generated method stub
		if(commentDao.addComment(comment))return true;
		else return false;
	}
	
	@Override
	public List<Comments> getAllCommentsById() {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		list=commentDao.getAllCommentById();
		return list;
	}
	
	@Override
	public Comments getCommentById(int id){
		Comments comment=new Comments();
		comment=commentDao.getCommentById(id);
		return comment;
	}

}
