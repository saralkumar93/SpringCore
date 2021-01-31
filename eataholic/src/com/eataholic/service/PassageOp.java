package com.eataholic.service;

import java.util.List;

import com.eataholic.model.Passage;

public interface PassageOp {
	//add a new passage into eataholic site
	public boolean addPassage(Passage passage);
	
	//delete a passage from site
	public boolean deletePassage(Passage passage);
	
	//update a passage from site
	public boolean updatePassage(Passage passage);
	
	//query passage by type
	public List<Passage> queryPassageByType_TimeRecent(String type);
	
	//query one passage by passage id
	public Passage getPassageById(int id);

	//query all passage by passage id asc
	public List<Passage> getAllPassageById();

	//query passage by author
	public List<Passage> getPassageByAuthor(String author);

}
