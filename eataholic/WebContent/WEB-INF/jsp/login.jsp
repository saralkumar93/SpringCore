<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>欢迎来到美食圈子</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="/eataholic/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/eataholic/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/eataholic/css/animate-custom.css" />
		<style>
			.container header h1{
				color:rgba(255,0,0,0.4);
			}
			.container header h1 span{
				color:rgba(255,0,0,0.6);
			}
			.log{
				color:rgba(255,0,0,0.6);
			}
		</style>
    </head>
    <body>
    	<%String error_s=(String) request.getAttribute("error"); 
    	  String error_register=(String) session.getAttribute("registerError");
    	%>
        <div class="container">
            <header >
                <h1>欢迎来到<span>美食圈子</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="SignInServlet" autocomplete="on" method="post"> 
                                <h1 class="log">登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" >美食圈名 </label>
                                    <input id="username" name="username" required="required" type="text" />
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p">通行口令</label>
                                    <input id="password" name="password" required="required" type="password"
                                    <%if(error_s==null||error_s==""){ %>
                                    placeholder="" /> 
                                    <%}
                                    else {%>
                                    placeholder="用户名或密码错误，请重试！" /> 
                                    <%} 
                                    request.setAttribute("error","");
                                    %>
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">记住密码</label>
								</p>
                                <p class="login button" > 
                                    <input type="submit" value="登录" style="background:#CD0000" /> 
								</p>
                                <p class="change_link">
									还未加入美食圈子？
									<a href="#toregister" class="to_register" style="color:rgba(255,0,0,0.8)">注册账号</a>
								</p>
                            </form>
                        </div>

 
                        <div id="register" class="animate form">
                            <form  action="RegisterServlet" autocomplete="on" method="post"> 
                                <h1> 注册 </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">美食圈名</label>
                                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" 
                                    <%if(error_register==null||error_register==""){ %>
                                    placeholder="" /> 
                                    <%}
                                    else if(error_register=="name_error") {%>
                                    placeholder="该用户名已被注册" /> 
                                    <%} %>
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" >邮箱</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email"
                                     <%if(error_register==null||error_register==""){ %>
                                    placeholder="" /> 
                                    <%}
                                    else if(error_register=="email_error") {%>
                                    placeholder="该邮箱已被注册" /> 
                                    <%} 
                                    %>
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">通行口令</label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认口令</label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password"
                                     <%if(error_register==null||error_register==""){ %>
                                    placeholder="" /> 
                                    <%}
                                    else if(error_register=="password_error") {%>
                                    placeholder="两次输入密码不一致" /> 
                                    <%} 
                                    session.setAttribute("registerError","");
                                    %>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="注册" style="background:#CD0000"/> 
								</p>
                                <p class="change_link">  
									已经是圈中一员？
									<a href="#tologin" class="to_register" style="color:rgba(255,0,0,0.8)">登录</a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>