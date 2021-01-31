<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.eataholic.model.Passage" %>
<%@ page import="com.eataholic.service.PassageOp" %>
<%@ page import="com.eataholic.service.impl.PassageOpImpl" %>
<%@ page import="com.eataholic.model.Users" %>
<%@ page import="com.eataholic.service.UserOp" %>
<%@ page import="com.eataholic.service.impl.UserOpImpl" %>
<%@ page import="com.eataholic.model.Comments" %>
<%@ page import="com.eataholic.service.CommentsOp" %>
<%@ page import="com.eataholic.service.impl.CommentsOpImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>美食分享</title>

  <link rel="stylesheet" href="css/style_ye.css?v=2">
  <script src="js/libs/modernizr-1.7.min.js"></script>
  <script src="/eataholic/ueditor/ueditor.parse.js"></script>
  <script type="text/javascript" src="/eataholic/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="/eataholic/ueditor/ueditor.all.js"></script>
  
    <style type="text/css">
	body, p { margin:0; padding:0;}
	* {font-family: Microsoft YaHei, Tahoma, sans-serif;}

	.itemBox { width:960px; height:500px; text-align:center; margin:auto; }
	.item { width:146px; height:200px; overflow:hidden; background-color:#FFFACD; 
			padding:10px; float:left; margin:10px; border-radius:15px;}
	.item h6 { padding:0; margin:4px 0; font-weight:normal; font-size:12px; color:#666; line-height:18px;}
	.item p {}
	.item p span { display:block; float:left; padding:3px 7px 3px 3px;background-color:#8c242d; font-size:12px; color:#fff;}
	.item p a { display:block; float:right; background-color:#e6e6e6; color:#666; font-size:12px; text-decoration:none; padding:3px 6px; text-align:center;}
	.photoinfo { border-radius:10px;}
	.photo { border-radius:10px; width:146px; height:146px;}
	.author{}
	.article_info{}
	.title{}
	.right_position{float:right;}
	.page{height:200;text-align:center; margin:auto;}

	.clear {content:".";display:block;clear:both;height:0;visibility:hidden;}
	.ul_float{float:left; }
	.newsletter{margin:0 200px;}
	.tr-style td{
		border-right:#cccccc solid 2px;
		border-left:#cccccc solid 2px;
		border-top:#cccccc solid 2px;
		border-bottom:#cccccc solid 2px;
	}
</style>
</head>
   
<body>
<% 
//登录判断
String username = "";
if (session.getAttribute("connecte") == null || !((String) session.getAttribute("connecte")).equals("true")) {
	 	System.out.println("Unlogin");
} 
else username=(String) session.getAttribute("login");



int curPage=(Integer) request.getAttribute("curPageAtt");
int pageCount=(Integer) request.getAttribute("pageCountAtt");

%>

<div class='wrapper_ye'>
  <header>
    <div class="top-nav">
      <nav>
        <ul>
          <%if(username.equals("")){ %>
           <li><a href="sign-in" id="login-btn">登录</a></li>
           <li><a href="sign-in#toregister" class="register-btn">注册</a></li>
           <%}
          else{%>
          <li><a href="UserServlet">欢迎<%=username%></a></li>
          <%} %>
            <li><a href="publish">上传文章</a></li>
			<li><a href="about.jsp">关于</a></li>
			<%if(username.equals("我是一条咸鱼")){ %>
			<li><a href="manage">管理</a></li>
			<%} %>
			<%if(!username.equals("")){ %>
			<li><a href="exit">注销</a></li>
			<%} %>
          </ul>
      </nav> 
      <form class="search-form" method="post">
         <input type="text" class="search">
         <input type="submit" class="search-submit" value="">
      </form>
    </div>

    <a href="index.jsp" class="logo"><img src="images/logo.png" alt="your logo" /></a>
			
	<nav class="main-menu">
		<ul>
		    <li><a href="index.jsp">主页</a></li>
			<li><a href="recipe">美食食谱</a></li>
			<li><a href="share">美食分享</a></li>
			<li><a href="anecdote">美食趣事</a></li>
			<li><a href="#">美食圈子</a></li>
			<li id="lava-elm"></li>
		</ul>
	</nav>
  </header>
   <div class="content clearfix">
	<div class="breadcrumbs">
		<ul>
			<li><a href="index.jsp">首页</a></li><!-- 需要替换成进入的页面 -->
			<li>美食趣事</li>
		</ul>
	</div>
	<div class="left-content"  >
	</div>
  </div>
   <div class="product-menu-header"><h2>美食趣事</h2></div>

	<!-- ***************************需要前端部分 ********START******************-->
	
	<div>
	<table border="2"  style="text-align:center; margin:0 30px; ">
			<thead >
				<th style="padding:50px;font-size:16px;">编号</th>
				<th style="padding:50px;font-size:16px;">标题</th>
				<th style="padding:50px;font-size:16px;">作者</th>
				<th style="padding:50px;font-size:16px;">类型</th>
				<th style="padding:50px;font-size:16px;">发布时间</th>
				<th style="padding:50px;font-size:16px;">操作</th>
			</thead>
      <%
      String type=(String) request.getAttribute("type");
      if(type.equals("passage")){
    	  List<Passage> passageList =new ArrayList<Passage>();
    	  passageList= (List<Passage>) request.getAttribute("passageList");
     	 for(Passage passage:passageList){
		%>
			<tr class="tr-style">
				<td style="padding:5px; font-size:16px;"><%=passage.getId() %></td>
				<td style="font-size:16px;"><%=passage.getTitle() %></td>
				<td style="font-size:16px;"><%=passage.getAuthor() %></td>
				<td style="font-size:16px;"><%=passage.getPassageType() %></td>
				<td style="font-size:16px;"><%=passage.getPassageTime() %></td>
				<td style="font-size:16px;">
					<a href="delete?deleteType=passage&deleteID=<%=passage.getId()%>">删除</a>
				</td>
			</tr>
		<%} 
		}
		else if(type.equals("comment")){
			List<Comments> commentsList =new ArrayList<Comments>();
			commentsList= (List<Comments>) request.getAttribute("commentList");
		  for(Comments comment:commentsList){
		%>
			<div>
                <span><%=comment.getId()%>" ></span>
            	  <span><%=comment.getBelong_User()%></span>
                	<span> <%=comment.getContent() %>  </span>
                	<span><%=comment.getRemarkTime()%>  </span>
          	</div>
		<%} 
		}%>
		
	</table>
	</div>
	</br>
	</br>
	<div class="page">
	      <a href = "manage?curPage=1" >首页</a>  
<a href = "manage?curPage=<%=curPage>1?curPage-1:curPage%>" >上一页</a>  
<a href = "manage?curPage=<%=curPage<pageCount?curPage+1:pageCount%>" >下一页</a>  
<a href = "manage?curPage=<%=pageCount%>" >尾页</a>  
第<%=curPage%>页/共<%=pageCount%>页
	</div>
	</div>
 <footer>
		<div class="footer-holder" >
			<a href="" class="logo">Cooker Logo</a>
				<div class="newsletter">
					<div class="quote">
						<h6>Newsletter</h6>
							<p>Sign-up for our newsletter and be always aware of the new offers and services:</p>
								<form method="post">
									<input type="text"><input type="submit" value="Submit" class="submit-button">
								</form>
							</div>
						</div>
						
						<div class="links">
							<h6>useful links</h6>
							<ul>
								<li><a href="#">联系我们</a></li>
								<li><a href="#">团队介绍</a></li>
								<li><a href="#">隐私政策</a></li>
								<li><a href="#">服务条款</a></li>
								<li><a href="#">广告合作</a></li>
								<li><a href="#">加入我们</a></li>
							</ul>
						</div>
						
			</div>
	</footer>
 
  <!-- ***************************需要前端部分 ********END******************-->
  
     
</body>
<script type="text/javascript" src="js/libs/jquery-1.7.1.min.js"></script>
<script src="js/libs/jquery.easing.1.3.js"></script>
<script src="js/script.js"></script>
<script src="js/libs/jquery.jcarousel.min.js"></script>	
</html>