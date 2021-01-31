package com.eataholic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eataholic.model.Passage;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.PassageOpImpl;

/**
 * Servlet implementation class ReadArticleServlet
 */
@WebServlet("/ReadArticleServlet")
public class ReadArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PassageOp passageOp=new PassageOpImpl();
		Passage passage=new Passage();
		String id=request.getParameter("id");
		int passage_id=Integer.parseInt(id);
		passage=passageOp.getPassageById(passage_id);
		if(passage==null){
			response.sendRedirect("error");
		}
		else{
			int click=passage.getClick();
			click++;
			passage.setClick(click);
			if(passageOp.updatePassage(passage)){
				String url="/WEB-INF/jsp/article.jsp?id="+id;
				request.getRequestDispatcher(url).forward(request, response);
			}
			else{
				response.sendRedirect("error");
			}
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
