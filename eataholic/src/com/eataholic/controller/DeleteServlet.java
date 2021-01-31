package com.eataholic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eataholic.model.Comments;
import com.eataholic.model.Passage;
import com.eataholic.service.CommentsOp;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.CommentsOpImpl;
import com.eataholic.service.impl.PassageOpImpl;
import com.sun.beans.editors.IntegerEditor;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("deleteType");
		String idstr=request.getParameter("deleteID");
		int id=Integer.parseInt(idstr);
		if(type.equals("passage")){
			PassageOp passageOp=new PassageOpImpl();
			Passage passage=new Passage();
			passage=passageOp.getPassageById(id);
			passageOp.deletePassage(passage);
			request.setAttribute("type","passage");
			
		}
		else if(type.equals("comment")){
			CommentsOp commentsOp=new CommentsOpImpl();
			Comments comment=new Comments();
			comment=commentsOp.getCommentById(id);
			commentsOp.deleteComment(comment);
			request.setAttribute("type","comment");
		}
		request.getRequestDispatcher("manage").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
