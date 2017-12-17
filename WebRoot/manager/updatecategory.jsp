<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>UpdateOldCategory</title>
  </head>
  
  <body>
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/UpdateCategoryServlet" method="post">
    	<table width="500px;">
    	<tr><td><input type="hidden" name="id" value="${findcategory.id}"></td></tr>
    	<tr>
    		<td>CategoryName：</td>
    		<td><input type="text" name="name" style="width: 200px" value="${findcategory.name}"></td>
    	<tr>
    	<tr>
    		<td>Description：</td>
    		<td><textarea rows="4" cols="40" name="description" >${findcategory.description}</textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="UpdateIt"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
