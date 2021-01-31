package com.eataholic.dao;

import java.util.List;

import com.eataholic.model.Passage;


public interface PassageDao {
	//Search passage by keyword
	public List<Passage> getPassageBySearch(String keyword);
	
	//get passage by author
	public List<Passage> getPassageByAuthor(String author);
	
	//get passage in descending order of click number
	public List<Passage> getPassageByClick();
	
	//get passage in descending order of like number
	public List<Passage> getPassageByLike();
	
	//get passage in descending order of comment number
	public List<Passage> getPassageByComment();
	
	//get passage by type in descending order of datetime
	public List<Passage> getPassageByType_TimeRecent(String type);
	
	//store a new passage in DB
	public boolean storePassage(Passage passage);
	
	//delete a passage in DB
	public boolean deletePassage(Passage passage);
	
	//get a passage by id from DB
	public Passage getPassageById(int id);

	//get all passage from DB by id asc
	public List<Passage> getAllPassageById();
	
}
