package com.eataholic.controller;

import java.io.IOException;
import java.sql.Timestamp;

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
 * Servlet implementation class RemarkServlet
 */
@WebServlet("/RemarkServlet")
public class RemarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//check logged state
		if(session.getAttribute("connecte")==null||!((String) session.getAttribute("connecte")).equals("true")){
			response.sendRedirect("sign-in");
		}
		else{//logged
			Comments comment=new Comments();
			CommentsOp commentsOp=new CommentsOpImpl();
			Passage passage=new Passage();
			PassageOp passageOp=new PassageOpImpl();
			
			String id=request.getParameter("id");
			int passage_id=Integer.parseInt(id);
			String user_name=(String) session.getAttribute("login");
			String content=request.getParameter("text");	
			comment.setBelong_Passage(passage_id);
			comment.setBelong_User(user_name);
			comment.setContent(content);
			Timestamp datetime = new Timestamp(System.currentTimeMillis()); 
			comment.setRemarkTime(datetime);
			
			passage=passageOp.getPassageById(passage_id);
			int comment_num=passage.getCommentNum();
			comment_num++;
			passage.setCommentNum(comment_num);
			if(commentsOp.addComment(comment)&&passageOp.addPassage(passage)){//评论成功
				String url="/WEB-INF/jsp/article.jsp?id="+id;
				request.getRequestDispatcher(url).forward(request, response);
			}
			else{
				response.sendRedirect("error");
			}
		}
	}

}
