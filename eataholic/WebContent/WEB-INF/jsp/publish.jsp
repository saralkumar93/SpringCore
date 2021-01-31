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
  <title>美食圈子</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <link rel="stylesheet" href="css/style_ye.css?v=2">
  <script src="js/libs/modernizr-1.7.min.js"></script>
  <script src="/eataholic/ueditor/ueditor.parse.js"></script>
  <script type="text/javascript" src="/eataholic/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="/eataholic/ueditor/ueditor.all.js"></script>
  <script>   
	function PreviewImage(imgFile) {
		var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
		if (!pattern.test(imgFile.value)) {
			alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
			imgFile.focus();
		} 
		path = URL.createObjectURL(imgFile.files[0]);
		document.getElementById("imgPreview").innerHTML = "<img src='"+path+"' style='width:200px; height:200px;' />";
	}
</script>
  <style>
  .newsletter{margin:0 200px;}
  </style>
</head>

<%
	//登录判断
    String username = "";
    if (session.getAttribute("connecte") == null || !((String) session.getAttribute("connecte")).equals("true")) {
   	 	System.out.println("Unlogin");
    } 
    else username=(String) session.getAttribute("login");
%>

<body>

<script type="text/javascript">
    var ue1 = UE.getEditor('myEditor');
</script>
    
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
			<li><a href="index.jsp">首页</a></li>
			<li>上传文章</li>
		</ul>
	</div>
	<div class="left-content"  style="padding-left: 80px;">

	  <form method="post" action="submit" class="form contact-form" >
	    <fieldset >
			<label for="contact-your-name">文章标题 <span class="required">*</span></label>
			<input type="text"  name="title" id="contact-your-email" class="input text">
			<label for="contact-subject">类别:<span class="required">*</span></label>
			<select name="type" id="contact-subject" class="input text">
      		    <option value="美食分享">美食分享</option>
        	    <option value="美食食谱">美食食谱</option>
        	    <option value="美食趣事">美食趣事</option>
    		</select>
    		<br></br>
    		<label for="contact-subject">封面:<span class="required">*</span></label>
    		<br></br>
    		<input type="file" name="pic" onchange='PreviewImage(this)'/>	
    		<br></br>
    		<div id="imgPreview" style="margin:0 30px;"> </div>
     		<br></br>
			<label for="contact-details">正文 <span class="required">*</span></label>
			<br></br>
			<br></br>
			<script id="myEditor" name="content" type="text/plain"></script>
						
			<button class="button">上传</button>
		</fieldset>
	  </form>
    </div>
  </div>		
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
	
</body>

<script type="text/javascript" src="js/libs/jquery-1.7.1.min.js"></script>
<script src="js/libs/jquery.easing.1.3.js"></script>
<script src="js/script.js"></script>
<script src="js/libs/jquery.jcarousel.min.js"></script>

</html>