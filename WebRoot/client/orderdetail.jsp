<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'orderdetail.jsp' starting page</title>
  </head>
  
  <body>
    <table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<h3>OrderDetails：</h3>
   		<tr>
   			<td>DeviceName</td>
   			<td>Price</td>
   			<td>Quantity</td>
   			<td>Payment</td>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${order.orderitems}">
   			<tr>
	   			<td>${orderitem.product.name }</td>
	   			<td>${orderitem.product.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }元</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">TotalPayment</td>
   			<td colspan="2">${order.price }Dollar</td>
   		</tr>
   	</table>
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
  		<h3>InfoAboutPeopleWhoReceiveTheProduct</h3>
  		<tr>
  			<td>Name</td>
  			<td>Fax</td>
  			<td>Phone</td>
  			<td>Address</td>
  			<td>Email</td>
  		</tr>
  		
  		<tr>
  			<td>${order.user.name }</td>
  			<td>${order.user.phone }</td>
  			<td>${order.user.cellphone }</td>
  			<td>${order.user.address }</td>
  			<td>${order.user.email }</td>
  		</tr>
  	</table>
  	<br/>
  </body>
</html>
