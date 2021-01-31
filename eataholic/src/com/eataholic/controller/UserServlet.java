package com.eataholic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eataholic.model.Users;
import com.eataholic.service.UserOp;
import com.eataholic.service.impl.UserOpImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		HttpSession session = request.getSession();
		//check logged state
		if(session.getAttribute("connecte")==null||!((String) session.getAttribute("connecte")).equals("true")){
			response.sendRedirect("sign-in");
		}
		else{//logged
			UserOp userOp=new UserOpImpl();
			Users user=new Users();
			String user_name=(String) session.getAttribute("login");
			//System.out.println(user_name);
			user=userOp.getUsersInfo(user_name);
			//System.out.println(user.getUserName());
			
			request.setAttribute("information", user);
			request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
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
