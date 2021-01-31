package com.eataholic.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eataholic.model.Users;
import com.eataholic.service.UserSignIn;
import com.eataholic.service.impl.UserSignInImpl;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(!username.equals("")&&!password.equals("")){
			UserSignIn userSign=new UserSignInImpl();
			Users user=new Users();
			user.setUserName(username);
			user.setPassCode(password);
			if(userSign.checkIdentity(user)){//login success,get info into cookie
				HttpSession session = request.getSession();
				/*//手动设置session的有效期为30分钟  
	            String sessionId = session.getId();  
	            Cookie cookie = new Cookie("JSESSIONID", sessionId);  
	            cookie.setMaxAge(60 * 30);  
	            cookie.setPath(request.getContextPath());  
	            response.addCookie(cookie); */
	            //加入用户登录信息
				session.setAttribute("connecte", "true");
				session.setAttribute("login", user.getUserName());
				String url="index.jsp";
				if(session.getAttribute("preurl")!=null){
					url=(String) session.getAttribute("preurl");
					session.removeAttribute("preurl");
				}
				response.sendRedirect(url);
			}
			else{//failure,return log page and send error message
				request.setAttribute("error","error");
				request.getRequestDispatcher("sign-in").forward(request, response);
			}
		}
		
	}

}
