package com.eataholic.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.eataholic.model.Passage;
import com.eataholic.service.PassageOp;
import com.eataholic.service.impl.PassageOpImpl;

/**
 * Servlet implementation class PublishServlet
 */
@WebServlet("/PublishServlet")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String content=request.getParameter("content");
		HttpSession session = request.getSession();
		//check logged state
		if(session.getAttribute("connecte")==null||!((String) session.getAttribute("connecte")).equals("true")){
			String url=request.getHeader("referer");
			System.out.println(url);
			session.setAttribute("preurl", url);
			response.sendRedirect("sign-in");
		}
		else{//logged
			Passage passage=new Passage();
			passage.setAuthor((String)session.getAttribute("login"));
			passage.setContent(content);
			passage.setClick(0);
			passage.setCommentNum(0);
			passage.setLikeNum(0);
			
			Timestamp datetime = new Timestamp(System.currentTimeMillis()); 
			passage.setPassageTime(datetime);
			passage.setTitle(request.getParameter("title"));
			String str="images/";
			passage.setPhoto(str+request.getParameter("pic"));
			passage.setPassageType(request.getParameter("type"));
			
			PassageOp passageOp=new PassageOpImpl();
			if(passageOp.addPassage(passage)){//success
				//to article
				System.out.println(passage.getId());
				Integer id=passage.getId();
				String idstr=id.toString();
				String url="article?id="+ idstr;
				response.sendRedirect(url);
			}
			else{
				//to error page
				response.sendRedirect("404.jsp");
			}
		}
	}

}
