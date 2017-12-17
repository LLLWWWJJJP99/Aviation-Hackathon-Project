<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  </head>
  
  <body style="text-align: center" class="p-3 mb-2 bg-light text-dark">
    <div id="content" style="width: 800px;">
    	
    	<div id="categorys" style="float: left;width: 200px;text-align:left;" class="p-3 mb-2 bg-info text-white">
    		Categories：
    		<ul>
    		<c:forEach var="category" items="${categorys}">
    			<li><a href="${pageContext.request.contextPath }/client/WelcomeServlet?category_id=${category.id }">${category.name }</a></li>
    		</c:forEach>
    		</ul>
    	</div>
    	
    	<div id="products" style="float: left;text-align:left;padding-left: 100px">
    		<c:forEach var="product" items="${page.list}">
    			<div id="product">
    				<div style="float: left">
    					<img src="${pageContext.request.contextPath }/images/${product.image }">
    				</div>
    				<div  style="float: left">
	    				<ul>
	    					<li>${product.name }</li>
	    					<li>${product.author }</li>
	    					<li>${product.price }</li>
	    					<li><a href="${pageContext.request.contextPath }/client/BuyServlet?productid=${product.id }">BuyIt</a></li>
	    				</ul>
    				</div>
    				<div style="clear: both"></div>
    				<br/><br/>
    			</div>
    		</c:forEach>
    	</div>
    	<div style="clear: both"></div>
    	<div id="listpagenum" class="container-fluid">
    			Current[${page.pagenum }]Page&nbsp;&nbsp;
   	
   		<c:forEach var="pageNum" begin="${page.foreachbegin}" end="${page.foreachend}">
   			[<a href="${pageContext.request.contextPath }/client/WelcomeServlet?pageNum=${pageNum }&category_id=${current_category_id }">${pageNum }</a>]
   		</c:forEach>
   	
   		&nbsp;&nbsp;There_are_[${page.totalpage }]Pages,There_are_[${page.totalrecord }]_Records
    	</div>
    </div>
  </body>
</html>
