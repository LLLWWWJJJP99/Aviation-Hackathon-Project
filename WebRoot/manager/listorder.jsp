<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listorder.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body style="text-align: center" class="container">
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%" class="table table-dark">
   		<caption><h2>OrderInfo</h2></caption>
   		<tr>
   			<td>PersonWhoMakeTheOrder</td>
   			<td>TimeWhenOrderCreated</td>
   			<td>OrderStatus</td>
 			<td>TotalPrice</td>
 			<td>Operations</td>
   		</tr>
   		
   		<c:forEach var="order" items="${orders}">
   			<tr>
   				<td>${order.user.name }</td>
   				<td>${order.ordertime }</td>
   				<td>${order.state==false?'NotSent':'AlreadySent' }</td>
   				<td>${order.price }</td>
	   			<td>
	   				<a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?order_id=${order.id }">Details</a>
	   				<!-- <a href="#">Update</a> -->
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
  </body>
</html>
