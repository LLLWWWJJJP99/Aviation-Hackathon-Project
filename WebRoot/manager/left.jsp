<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>NavigationPage</title>
    
    <style type="text/css">
      .dc { 
      		margin-left: 10px;
      	  }
	</style>
	
	<script language="javascript">
	      function test(e) {
	            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;       
	      }
	</script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  
  </head>
  
  <body class="p-3 mb-2 bg-warning text-white">
    <ul>
    	<li>
    		<a href="#" onclick="test(children[0])">CategoryManagement
    			<div class="dc">
	    			<a href="${pageContext.request.contextPath }/manager/addcategory.jsp"  target="right">AddCatgegory</a><br/>
	    			<a href="${pageContext.request.contextPath }/manager/ListCategoryServlet"  target="right">ShowAllCategory</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">ProductManagement
    			<div class="dc">
	    				<a href="${pageContext.request.contextPath }/manager/ForAddProductServlet"  target="right">AddProduct</a><br/>
	    				<a href="#"  onclick="test(children[0])">ShowProduct
		    				<div class="dc">
		    					<c:forEach var="category" items="${categorys}">
			    					<a href="${pageContext.request.contextPath }/manager/ListProductByPage?category_id=${category.id }"  target="right">${category.name }</a><br/>
			    				</c:forEach>
		    				</div>
	    				</a>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">OrderManagement
	    		<div class="dc">
	    			<a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=false"  target="right">OrderNotProcessed</a><br/>
	    			<a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=true"  target="right">OrderProcessed</a><br/>
	    		</div>
    		</a>
    	</li>
    	<br/><br/>
    </ul>
  </body>
</html>
