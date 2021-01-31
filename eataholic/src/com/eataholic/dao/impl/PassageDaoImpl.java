package com.eataholic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.eataholic.dao.PassageDao;
import com.eataholic.model.Passage;
import com.eataholic.model.Users;

public class PassageDaoImpl implements PassageDao {
	Session session=new Configuration().configure().buildSessionFactory().openSession();  
    Transaction transaction=session.beginTransaction();  
	@Override
	public boolean storePassage(Passage passage){
		try{
			session.save(passage);
			transaction.commit();
			session.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	@Override
	public List<Passage> getPassageBySearch(String keyword){
		List<Passage> list=new ArrayList<Passage>();
		keyword="%"+keyword+"%";
		try{
			list=session.createQuery("select p from Passage as p where p.title like ?").setParameter(0,keyword).list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Passage> getPassageByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p where p.author like ? order by p.passageTime desc").setParameter(0,author).list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Passage> getPassageByClick() {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p order by p.click desc,p.passageTime desc").list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Passage> getPassageByLike() {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p order by p.likeNum desc,p.passageTime desc").list();		
		}
	    catch(Exception e){
	    }
		return list;
	}
	
	
	@Override
	public List<Passage> getAllPassageById() {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p order by p.id asc").list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Passage> getPassageByComment() {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p order by p.commentNum desc,p.passageTime desc").list();		
		}
	    catch(Exception e){
	    }
		return list;
	}

	@Override
	public List<Passage> getPassageByType_TimeRecent(String type) {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		try{
			list=session.createQuery("select p from Passage as p where p.passageType like ? order by p.passageTime desc").setParameter(0, type).list();		
		}
	    catch(Exception e){
	    }
		return list;
	}
	
	@Override
	public boolean deletePassage(Passage passage){
		try{
			session.delete(passage); 
			transaction.commit();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	@Override
	public Passage getPassageById(int id){
		Passage passage=new Passage();
		try{
			passage=(Passage) session.get(Passage.class,id);  		
		}
		catch(Exception e){
			
	    }
		return passage;
	}
}
