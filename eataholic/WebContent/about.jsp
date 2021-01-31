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
    
<!doctype html>
<html>
<head>
  <meta charset="utf-8">

  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>美食圈子</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="shortcut icon" href="/favicon.ico">

  <link rel="stylesheet" href="css/style_ye.css?v=2">
  <link rel="stylesheet" href="../css/jcarousel.css">
  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-1.7.min.js"></script>
  <style>
  	.image-sty{
  		 border-radius:75px;
  		 width:150px;
  		 height:150px;
  	}

  	.li-style li{
  		float:left;
  		width:150px;
  		height:200px;
  		padding:50px;
  		margin:20px 30px;
  		
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
%>

<body>
  <div class='wrapper_ye'>
    <header>
      <div class="top-nav">
        <nav>
          <ul>
          <%if(username==""){ %>
           <li><a href="sign-in" id="login-btn">登录</a></li>
           <li><a href="sign-in#toregister" class="register-btn">注册</a></li>
           <%}
          else{%>
          <li><a href="UserServlet">欢迎<%=username%></a></li>
          <%} %>
           <li><a href="publish">上传文章</a></li>
			<li><a href="eataholic/about.html">关于</a></li>
          </ul>
        </nav> 
               <form class="search-form" method="post">
          <input type="text" class="search">
          <input type="submit" class="search-submit" value="">
        </form>
      </div>

       <a href="index.html" class="logo"><img src="images/logo.png" alt="your logo" /></a>
			<nav class="main-menu">
				<ul>
				<li><a href="index.jsp">主页</a></li>
				<li><a href="">美食食谱</a></li>
				<li><a href="">美食分享</a></li>
				<li><a href="">美食趣事</a></li>
				<li><a href="">美食圈子</a></li>
				<li id="lava-elm"></li>
			</ul>
			</nav>
    </header>
    
		<div class="content full-content clearfix">
			<div class="breadcrumbs">
				<ul>
					<li><a href="index.jsp">首页</a></li>
					<li>关于我们</li>
				</ul>
			</div>
			
			<ul class="li-style">			
			<li >
				<div>
					<image src="images/lcy.jpg" class="image-sty"></image>
					<h1>刘诚阳</h1>
					<p>Eataholic项目总工程师兼后端</p>
					<p></p>
					<p><b>科学技术是第一生产力，吃饱饭是第一生产力的前驱。</b></p>
				</div>
			</li>
			<li >
				<div>
					<image src="images/ybb.jpg" class="image-sty"></image>
					<h1>叶冰冰</h1>
					<p>Eataholic前端总工程师</p>
					<p></p>
					<p><b>没有我画不出的东西，没有我写不出的前端。</b></p>
				</div>
			</li>
			<li >
				<div>
					<image src="images/syy.jpg" class="image-sty"></image>
					<h1>宋寅瑜</h1>
					<p>Eataholic项目前端技术总监</p>
					<p></p>
					<p><b>为什么满脑子都是红烧肉QAQ</b></p>
				</div>
			</li>
			<li >
				<div>
					<image src="images/lzb.jpg" class="image-sty"></image>
					<h1>李志博</h1>
					<p>Eataholic项目非洲情报收集员</p>
					<p></p>
					<p><b>我得到的情报永远是最好的~</b></p>
				</div>
			</li>
			<li >
				<div>
					<image src="images/zjj.jpg" class="image-sty"></image>
					<h1>张竣杰</h1>
					<p>Eataholic项目特派员</p>
					<p></p>
					<p><b>What's the next?</b></p>
				</div>
			</li>
			<li >
				<div>
					<image src="images/xy.jpg" class="image-sty"></image>
					<h1>相莹</h1>
					<p>Eataholic项目特派员</p>
					<p></p>
					<p><b>打开新世界的大门，为了对知识的向往与渴求~</b></p>
				</div>
			</li>
			</ul>

			

	</div>
	

	
		<footer>
			<div class="footer-holder">
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
    </div>
	<script type="text/javascript" src="js/libs/jquery-1.7.1.min.js"></script>
  <script src="js/libs/jquery.easing.1.3.js"></script>
  <script src="js/script.js"></script>
  <script src="js/libs/jquery.jcarousel.min.js"></script>	
</body>

</html>