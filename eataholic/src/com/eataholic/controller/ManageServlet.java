package com.eataholic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eataholic.model.Comments;
import com.eataholic.model.Passage;
import com.eataholic.service.CommentsOp;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.CommentsOpImpl;
import com.eataholic.service.impl.PassageOpImpl;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("connecte")!=null&&((String) session.getAttribute("connecte")).equals("true")
				&&((String) session.getAttribute("login")).equals("我是一条咸鱼")){
			int pageCount,curPage=1;
			int size;
			int pageSize=10;
			if(request.getAttribute("type")==null||request.getAttribute("type").equals("passage")){
				PassageOp passageOp =new PassageOpImpl();
				List<Passage> passageList =new ArrayList<Passage>();
				passageList=passageOp.getAllPassageById();
				size=passageList.size();
				pageCount = (size%pageSize==0)?(size/pageSize):(size/pageSize+1);//计算页的总数
				String tmp = request.getParameter("curPage");//获取当前页
		        if(tmp==null){  
		            tmp="1";  
		        }  
		        curPage = Integer.parseInt(tmp);  
		        if(curPage>pageCount) curPage = pageCount;
		        
		        int start=(curPage-1)*pageSize;
		        int i=0;
		        List<Passage> passageListByPage =new ArrayList<Passage>();
		        
		        for(i=0;start<size&&i<pageSize;i++,start++){
		        	passageListByPage.add(passageList.get(start));
		        }
		        request.setAttribute("type", "passage");
		        request.setAttribute("passageList",passageListByPage);
			}
			else{
				CommentsOp commentOp =new CommentsOpImpl();
				List<Comments> commentList =new ArrayList<Comments>();
				commentList=commentOp.getAllCommentsById();
				size=commentList.size();
				pageCount = (size%pageSize==0)?(size/pageSize):(size/pageSize+1);//计算页的总数
				String tmp = request.getParameter("curPage");//获取当前页
		        if(tmp==null){  
		            tmp="1";  
		        }  
		        curPage = Integer.parseInt(tmp);  
		        if(curPage>pageCount) curPage = pageCount;
		        
		        int start=(curPage-1)*pageSize;
		        int i=0;
		        List<Comments> commentListByPage =new ArrayList<Comments>();
		        
		        for(i=0;start<size&&i<pageSize;i++,start++){
		        	commentListByPage.add(commentList.get(start));
		        }
		        request.setAttribute("type", "comment");
		        request.setAttribute("commentList",commentListByPage);
			}
	        request.setAttribute("curPageAtt", new Integer(curPage));
	        request.setAttribute("pageCountAtt",new Integer(pageCount));
	        request.getRequestDispatcher("/WEB-INF/jsp/manage.jsp").forward(request, response);
		}
		else{
			//go to 404
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
