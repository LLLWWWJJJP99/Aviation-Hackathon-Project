<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>AddNewCategory</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body class="p-3 mb-2 bg-light text-dark">
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/AddCategoryServlet" method="post" class="container">
    	<table width="500px;">
    	<tr>
    		<td>CategoryName：</td>
    		<td><input type="text" name="name" style="width: 200px" class="form-control"></td>
    	<tr>
    	<tr>
    		<td>Description：</td>
    		<td><textarea rows="4" cols="40" name="description" class="form-control"></textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="AddIt" class="btn btn-primary btn-lg"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
