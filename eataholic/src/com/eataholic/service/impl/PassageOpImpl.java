package com.eataholic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.eataholic.dao.PassageDao;
import com.eataholic.dao.UserDao;
import com.eataholic.dao.impl.PassageDaoImpl;
import com.eataholic.dao.impl.UserDaoImpl;
import com.eataholic.model.Passage;
import com.eataholic.service.PassageOp;

public class PassageOpImpl implements PassageOp{
	
	PassageDao passageDao=new PassageDaoImpl();
	@Override
	public boolean addPassage(Passage passage) {
		// TODO Auto-generated method stub
		if(passageDao.storePassage(passage))return true;
		else return false;
	}

	@Override
	public boolean deletePassage(Passage passage) {
		// TODO Auto-generated method stub
		if(passageDao.deletePassage(passage))return true;
		else return false;
	}

	@Override
	public boolean updatePassage(Passage passage) {
		// TODO Auto-generated method stub
		if(passageDao.storePassage(passage))return true;
		else return false;
	}

	@Override
	public List<Passage> queryPassageByType_TimeRecent(String type) {
		// TODO Auto-generated method stub
		List<Passage> list=new ArrayList<Passage>();
		list=passageDao.getPassageByType_TimeRecent(type);
		return list;
	}
	
	@Override
	public Passage getPassageById(int id){
		Passage passage=new Passage();
		passage=passageDao.getPassageById(id);
		return passage;
	}
	
	@Override
	public List<Passage> getAllPassageById(){
		List<Passage> passageList=new ArrayList<Passage>();
		passageList=passageDao.getAllPassageById();
		return passageList;
	}
	
	@Override
	public List<Passage> getPassageByAuthor(String author){
		List<Passage> passageList=new ArrayList<Passage>();
		passageList=passageDao.getPassageByAuthor(author);
		return passageList;
	}

}
