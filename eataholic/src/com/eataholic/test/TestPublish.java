package com.eataholic.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.eataholic.model.Passage;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.PassageOpImpl;

public class TestPublish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Passage passage=new Passage();
		passage.setAuthor("我是一条咸鱼");
		passage.setContent("ASASFSHDJDKGFJD5156165VS5S65H1631SF5A136dgsdgsgd");
		passage.setClick(0);
		passage.setCommentNum(0);
		passage.setLikeNum(0);

		Timestamp datetime = new Timestamp(System.currentTimeMillis()); 
		passage.setPassageTime(datetime);
		passage.setPassageType("美食分享");
		passage.setPhoto("123");
		passage.setTitle("hdiaolfs");
		System.out.println(passage.getPassageTime());
		
		PassageOp passageOp=new PassageOpImpl();
		if(!passageOp.addPassage(passage)){//success
			//to article
			System.out.println("ok");
		}*/
		//to article
		
		PassageOp pa=new PassageOpImpl();
		List<Passage> paShare = pa.queryPassageByType_TimeRecent("美食分享");
		for(Passage n:paShare){
			System.out.println(n.getContent());
		}
	}

}
