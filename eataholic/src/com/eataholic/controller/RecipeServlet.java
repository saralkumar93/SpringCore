package com.eataholic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eataholic.model.Passage;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.PassageOpImpl;

/**
 * Servlet implementation class RecipeServlet
 */
@WebServlet("/RecipeServlet")
public class RecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PassageOp passageOp =new PassageOpImpl();
		List<Passage> passageList =new ArrayList<Passage>();
		int pageCount,curPage=1;
		int size;
		int pageSize=10;
		String type="美食食谱";
		passageList=passageOp.queryPassageByType_TimeRecent(type);
		size=passageList.size();
		pageCount = (size%pageSize==0)?(size/pageSize):(size/pageSize+1);//计算页的总数
		//System.out.println(size);
		String tmp = request.getParameter("curPage");//获取当前页
        if(tmp==null){  
            tmp="1";  
        }  
        curPage = Integer.parseInt(tmp);  
        //System.out.println(curPage);
        if(curPage>pageCount) curPage = pageCount;
        
        int start=(curPage-1)*pageSize;
        int i=0;
        List<Passage> passageListByPage =new ArrayList<Passage>();
        //System.out.println(pageCount);
        
        for(i=0;start<size&&i<pageSize;i++,start++){
        	
        	//System.out.println(start);
        	passageListByPage.add(passageList.get(start));
        }
        request.setAttribute("passageList",passageListByPage);
        request.setAttribute("curPageAtt", new Integer(curPage));
        request.setAttribute("pageCountAtt",new Integer(pageCount));
        request.getRequestDispatcher("/WEB-INF/jsp/recipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
