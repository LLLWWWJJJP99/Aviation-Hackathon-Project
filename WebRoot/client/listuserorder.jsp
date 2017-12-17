<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listorder.jsp' starting page</title>
  </head>
  
  <body style="text-align: center">
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>OrderDetail</h2></caption>
   		<tr>
   			<td>CustomerName</td>
   			<td>TimeW</td>
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
	   				<a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?order_id=${order.id }">OrderDetails</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
  </body>
</html>
