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
	.newsletter{margin:0 200px;}
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

List<Passage> passageList =new ArrayList<Passage>();
passageList= (List<Passage>) request.getAttribute("passageList");

int curPage=(Integer) request.getAttribute("curPageAtt");
int pageCount=(Integer) request.getAttribute("pageCountAtt");

System.out.println(curPage);
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
			<li>美食分享</li>
		</ul>
	</div>
	<div class="left-content"  >
	</div>
  </div>
   <div class="product-menu-header"><h2>美食分享</h2></div>

	<!-- ***************************需要前端部分 ********START******************-->
	<div class="itemBox">
      <%for(Passage passage:passageList){
    	    Users user=new Users();
			UserOp uo=new UserOpImpl();
			user=uo.getUsersInfo(passage.getAuthor());
		%>
			<div class="item">
                <a href="article?id=<%=passage.getId()%>" >
                    <img class="photo" src="<%=passage.getPhoto() %>" alt="<%=passage.getTitle()%>"/>
                </a>
                <div class="title"><b><span><%=passage.getTitle()%></span></b></div>
                <div class="article_info">
                	<span>点击 <%=passage.getClick()%>  </span>
                	<span>评论 <%=passage.getCommentNum()%>  </span>
                	<span>喜爱 <%=passage.getLikeNum()%></span>
                </div>
            
            <a class="author" >
           		<span><img class="photoinfo" width="20" height="20" src="<%=user.getProfil()%>" alt=""></span>
          		<span><%=passage.getAuthor()%></span>
          	</a>
          	</div>
		<%} %>
	</div>
	
	<div class="page">
	      <a href = "share?curPage=1" >首页</a>  
<a href = "share?curPage=<%=curPage>1?curPage-1:curPage%>" >上一页</a>  
<a href = "share?curPage=<%=curPage<pageCount?curPage+1:pageCount%>" >下一页</a>  
<a href = "share?curPage=<%=pageCount%>" >尾页</a>  
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