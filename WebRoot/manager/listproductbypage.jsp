<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listproductbypage.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  </head>
	<body style="text-align: center" class="container">
   	<br/><br/>
   	
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%" class="table table-hover table-dark">
   		<caption><h2>ProductInfo</h2></caption>
   		<tr>
   			<td>Name</td>
   			<td>Seller</td>
   			<td>Description</td>
   			<td>Picture</td>
 			<td>Operation</td>
   		</tr>
   		
   		<c:forEach var="product" items="${page.list}">
   			<tr>
   				<td>${product.name }</td>
   				<td>${product.author}</td>
   				<td>${product.description }</td>
   				<td><a href="${pageContext.request.contextPath }/images/${product.image }" class="rounded float-left">ShowPicture</a></td>
	   			<td>
	   				<a href="${pageContext.request.contextPath }/manager/UpdateProductUIServlet?id=${product.id}">Update</a>
	   				<a href="${pageContext.request.contextPath }/manager/DeleteProductUIServlet?id=${product.id}">Delete</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	<br/><br/>
   	
   	Current[${page.pagenum }]Page&nbsp;&nbsp;
   	
   		<c:forEach var="pageNum" begin="${page.foreachbegin}" end="${page.foreachend}">
   			[<a href="${pageContext.request.contextPath }/manager/ListProductByPage?pageNum=${pageNum }&category_id=${category_id }">${pageNum }</a>]
   		</c:forEach>
   	
   &nbsp;&nbsp;ThereAre[${page.totalpage }]Pages,ThereAre[${page.totalrecord }]RecordsInTotal
   	
    
  </body>
</html>
