<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listcart.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body style="text-align: center">
   	<br/><br/>
   	
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%" class="table table-dark">
   		<caption><h2>CartInfo</h2></caption>
   		<tr>
   			<td>Name</td>
   			<td>Price</td>
   			<td>Quantitty</td>
   			<td>Total</td>
   		</tr>
   		
   		<c:forEach var="entry" items="${cart.map}">
   			<tr>
	   			<td>${entry.value.product.name }</td>
	   			<td>${entry.value.product.price }</td>
	   			<td>${entry.value.quantity }</td>
	   			<td>${entry.value.totalprice }Dollars</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">TotalPrice</td>
   			<td colspan="2">${cart.totalprice }Dollars</td>
   		</tr>
   	</table>
    <a href="${pageContext.request.contextPath }/client/OrderServlet">GenerateOrders</a>
  </body>
</html>
