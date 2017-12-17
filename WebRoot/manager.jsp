<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'manager.jsp' starting page</title>
  </head>
  
  <frameset rows="18%,*">
  		<frame src="managerhead.jsp">
  		<frameset  cols="15%,*">
	  		<frame src="${pageContext.request.contextPath }/manager/ForLeftInfoServlet" name="left">
	 		<frame src="#" name="right">
 		</frameset>
  </frameset>
</html>
