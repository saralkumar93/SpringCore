package com.eataholic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.eataholic.dao.CommentsDao;
import com.eataholic.model.Comments;
import com.eataholic.model.Passage;

public class CommentsDaoImpl implements CommentsDao{
	Session session=new Configuration().configure().buildSessionFactory().openSession();  
    Transaction transaction=session.beginTransaction();  
    
	@Override
	public boolean addComment(Comments comment) {
		// TODO Auto-generated method stub
		try{
			session.save(comment);
			transaction.commit();
			session.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteComment(Comments comment) {
		// TODO Auto-generated method stub
		try{
			session.delete(comment); 
			transaction.commit();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<Comments> getCommentByPassage(int passage_id) {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		try{
			list=session.createQuery("select c from Comments as c where c.belong_Passage like ? order by c.remarkTime desc").setParameter(0, passage_id).list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Comments> getCommentByUser(String userName) {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		try{
			list=session.createQuery("select c from Comments as c where c.belong_User like ? order by c.remarkTime desc").setParameter(0, userName).list();		
		}
	    catch(Exception e){
	    }
		return list;
	}
	
	@Override
	public List<Comments> getAllCommentById() {
		// TODO Auto-generated method stub
		List<Comments> list=new ArrayList<Comments>();
		try{
			list=session.createQuery("select c from Comments as c order by c.id asc").list();		
		}
	    catch(Exception e){
	    }
		return list;
	}
	
	@Override
	public Comments getCommentById(int id){
		Comments comment=new Comments();
		try{
			comment=(Comments) session.get(Comments.class,id);  		
		}
		catch(Exception e){
			
	    }
		return comment;
	}

}
