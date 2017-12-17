<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body style="text-align: center">
    
    <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post" class="container">
    	<table width="300px">
    	<caption><h2>UserRegistration</h2></caption>
    	<tr>
    		<td>UserName</td>
    		<td><input type="text" name="name" style="width: 200px" class="form-control"></td>
    	<tr>
    	<tr>
    		<td>Password</td>
    		<td><input type="password" name="password" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Fax</td>
    		<td><input type="text" name="phone" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>CellPhone</td>
    		<td><input type="text" name="cellphone" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Address</td>
    		<td><input type="text" name="address" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Email</td>
    		<td>
    			<input type="text" name="email" style="width: 200px" class="form-control">
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="SignUp" class="btn btn-primary btn-lg"></td>
    	</tr>
    	</table>
    </form>
    
    
  </body>
</html>
