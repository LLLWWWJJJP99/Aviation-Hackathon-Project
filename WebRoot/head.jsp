<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>head</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body style="text-align: center" class="p-3 mb-2 bg-warning text-white">
    <h1>ISL Online Auction</h1>
    
    
    <div style="margin-left: 40%;float: left">
    
    <a href="${pageContext.request.contextPath }/client/WelcomeServlet"  target="body">&nbsp;&nbsp;&nbsp;Home Page&nbsp;&nbsp;&nbsp;</a>
	<a href="${pageContext.request.contextPath }/client/ListCartServlet"  target="body">&nbsp;&nbsp;&nbsp;Check My Cart&nbsp;&nbsp;&nbsp;</a>
	<a href="${pageContext.request.contextPath }/client/ListUserOrderServlet"  target="body">&nbsp;&nbsp;&nbsp;Check My Orders&nbsp;&nbsp;&nbsp;</a>
	 
  	</div>
  	
  	<div style="float: right;" class="progress-bar bg-warning">
  		<c:if test="${sessionScope.user==null}">
  			<form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
	  			Username：<input type="text" name="name" style=" width: 50px" class="rounded">
	  			Password：<input type="password" name="password" style="width: 50px" class="rounded">
	  			<select name="usertype" class="custom-select">
	  				<option value= "seller">Seller</option>
	  				<option value="user">User</option>
	  			</select>
	  			<input type="submit" value="Login" class="btn btn-outline-success">
	  			<input type="button" value="UserRegister" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath }/client/register.jsp'" class="btn btn-outline-primary">
  				<input type="button" value="SellerRegister" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath }/client/register_seller.jsp'" class="btn btn-outline-secondary">
  			</form>
  			${requestScope.message }
  		</c:if>
  		
  		<c:if test="${sessionScope.user!=null}">
  			Welcome You：${user.name }&nbsp;&nbsp;&nbsp;&nbsp;
  		</c:if>
  	</div>
  	<div style="clear: both"></div>
  	
  </body>
</html>
