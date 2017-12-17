<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>AddProduct</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body>
    
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/AddProductServlet" method="post" enctype="multipart/form-data" class="container">
    	<table width="500px">
    	
    	<tr>
    		<td>Name</td>
    		<td><input type="text" name="name" style="width: 200px" class="form-control"></td>
    	<tr>
    	<tr>
    		<td>Seller</td>
    		<td><input type="text" name="author" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Price</td>
    		<td><input type="text" name="price" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Picture</td>
    		<td><input type="file" name="filename" style="width: 200px" class="form-control"></td>
    	</tr>
    	<tr>
    		<td>Descrption</td>
    		<td><textarea rows="4" cols="40" name="description" class="form-control"></textarea></td>
    	</tr>
    	<tr>
    		<td>Category</td>
    		<td>
    			<select name="category_id" class="custom-select">
    				<c:forEach var="category"  items="${categorys}">
    					<option value="${category.id }">${category.name }</option>
    				</c:forEach>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="Add_It" class="btn btn-primary btn-lg"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
