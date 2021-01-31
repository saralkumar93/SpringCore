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
<title>个人空间</title>
    <link rel="stylesheet" href="css/skel.css" />
    <link rel="stylesheet" href="css/style4.css" />
    <link rel="stylesheet" href="css/style-xlarge.css" />

    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
    
    <style>
   .ul-list li{
    	float:left;
    	list-style:none;
    	margin:0 20px;
    }
    .nav{
    width:800px;
    height:50px;
    margin:0 350px;
    }
    .image-profil{
    	width:150px;
    	height:135px;
    	border-radius:50px;
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

Users user=new Users();
user=(Users) request.getAttribute("information");
%>

<div class="nav">
	<ul class="ul-list">
			<li><a href="index.jsp">主页</a></li>
			<li><a href="recipe">美食食谱</a></li>
			<li><a href="share">美食分享</a></li>
			<li><a href="anecdote">美食趣事</a></li>
			<li><a href="#">美食圈子</a></li>
		</ul>
</div>

		

<div id="wrapper" style="margin: 0px 100px;">
    <!-- Header -->
    <section id="header" class="skel-layers-fixed" style="background-color: #D32F2F;">
        <header>
            <span class="image avatar"><img class="image-profil" src="<%=user.getProfil() %>" alt="我的照骗"/></span>
            <h1><%=user.getUserName() %> </h1>
            <p>I never stop eat delicious food<br/>
                and now I'm hungry!</p>
        </header>
        <nav id="nav">
            <ul>
                <li><a href="#one" class="active">个人信息</a></li>
                <li><a href="#two">我的文章</a></li>
            </ul>
        </nav>
    </section>

    <!-- Main -->
    <div id="main">
        <!-- One -->
        <section id="one" >
            <div class="container" margin=0,0 >
                <header class="major">
                    <h2 style="font-size: 72px">关于我</h2>
                </header>
                <h4 >语录</h4>
                <p style="font-size: 18px">
                <%=user.getDescription() %>
                </p>
                <h4 style="margin: 35px 0;">个人简介</h4>
                <section>
                    <div class="table-wrapper">
                        <table>
                            <tbody>
                            <tr>
                                <td>用户名：</td>
                                <td><%=user.getUserName() %></td>
                            </tr>
                            <tr>
                                <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                                <td><%=user.getGender() %></td>
                            </tr>
                            <tr>
                                <td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
                                <td><%=user.getEmail() %></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </section>

        <!-- Two -->
        <section id="two">
            <div class="container">
                <h3>我的文章</h3>
                <p>作为一名资深吃货，我可发表过不少文章哟！</p>
                <div class="features">
                <%
                PassageOp passageOp=new PassageOpImpl();
                List<Passage> passageList=new ArrayList<Passage>();
                passageList=passageOp.getPassageByAuthor(user.getUserName());
                for(Passage passage:passageList){
                %>
                    <article>
                        <a href="article?id=<%=passage.getId() %>" class="image"><img style="width:200px;height:200px" src="<%=passage.getPhoto() %>"/></a>
                        <div class="inner">
                            <h4><%=passage.getTitle() %></h4>
                            <p style="font-size:10px; margin:0 100px;"><%=passage.getPassageTime() %></p>
                        </div>
                    </article>
                 <%} %>
                </div>
            </div>
        </section>
    </div>
</div>
<div>


</div>

<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min2.js"></script>
<script src="js/jquery.scrollzer.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
</body>
</html>