<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>UpdateProduct</title>
  </head>
  
  <body>
    
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/UpdateProductServlet" method="post" enctype="multipart/form-data">
    	<table width="500px">
    	<tr><td><input type="hidden" name="id" value="${updateproduct.id}"></td></tr>
    	<tr>
    		<td>Name</td>
    		<td><input type="text" name="name" value="${updateproduct.name }" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>Seller</td>
    		<td><input type="text" name="author" value="${updateproduct.author }" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>Price</td>
    		<td><input type="text" name="price" value="${updateproduct.price }" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>Previous Picture:${updateproduct.image }</td>
    		<td><input type="file" name="filename" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>Descrption</td>
    		<td><textarea rows="4" cols="40" name="description">${updateproduct.description }</textarea></td>
    	</tr>
    	<tr>
    		<td>Category</td>
    		<td>
    			<select name="category_id">
    				<c:forEach var="category"  items="${categorys}">
    					<option value="${category.id }" ${category.id == updateproduct.category_id? 'selected="selected"' :''}>${category.name }</option>
    				</c:forEach>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="Update_It"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
