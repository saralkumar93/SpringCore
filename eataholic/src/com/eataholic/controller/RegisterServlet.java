package com.eataholic.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.eataholic.model.Users;
import com.eataholic.service.UserRegister;
import com.eataholic.service.impl.UserRegisterImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   /* @Override  
    public void init(ServletConfig config) throws ServletException  
    {  
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());  
    }  */

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
		String username = request.getParameter("usernamesignup");
		String password = request.getParameter("passwordsignup");
		String password_confirm = request.getParameter("passwordsignup_confirm");
		String email = request.getParameter("emailsignup");
		HttpSession session = request.getSession();
		if(!username.equals("")&&!password.equals("")&&!email.equals("")&&!password_confirm.equals("")){
			if(!password.equals(password_confirm)){
				session.setAttribute("registerError","password_error");
				response.sendRedirect("sign-in#toregister");
			}
			else{
				Users user=new Users();
				user.setUserName(username);
				user.setPassCode(password);
				user.setEmail(email);
				user.setDescription("这家伙很懒，什么都没留下...");
				user.setProfil("images/default.jpg");
				user.setGender("未知");
				//System.out.println(username);
				UserRegister userRegister=new UserRegisterImpl();
				int code=userRegister.addUser(user);
				//System.out.println(code);
				if(code>0){//success
					response.sendRedirect("sign-in");
				}
				else{//failure		
					if(code==-1||code==-2){
						if(code==-1){
							session.setAttribute("registerError","name_error");
						}
						else{
							session.setAttribute("registerError","email_error");
						}
						response.sendRedirect("sign-in#toregister");
						//request.getRequestDispatcher("sign-in#toregister").forward(request, response);
					}
					else{
						response.sendRedirect("error");
					}			
				}
			}
		}
	}

}
