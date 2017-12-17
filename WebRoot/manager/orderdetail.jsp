<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'orderdetail.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  </head>
  
  <body class="container">
    <table frame="border" cellpadding="0" cellspacing="0" width="90%" class="table table-dark">
   		<h3>OrderDetails</h3>
   		<tr>
   			<td>Name</td>
   			<td>Price</td>
   			<td>Quantity</td>
   			<td>Payment</td>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${order.orderitems}">
   			<tr>
	   			<td>${orderitem.product.name }</td>
	   			<td>${orderitem.product.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }Dollar</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">TotalPrice</td>
   			<td colspan="2">${order.price }Dollar</td>
   		</tr>
   	</table>
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
  		<h3>InfoAboutCustomerWhoReceiveTheProduct</h3>
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
  	<a href="${pageContext.request.contextPath }/manager/ConfirmOrderServlet?order_id=${order.id }">ConfirmToSend</a>
  </body>
</html>
