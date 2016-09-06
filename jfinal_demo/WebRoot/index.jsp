<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
    <table > 
    <tr>    
        <td>Name</td>  
        <td>Age</td> 
        <td>Sex</td>
        <td>class</td>
    </tr>  
    <c:forEach items="${studentList}" var="student">  
    <tr>
        <td ><input  value="${student.studentname}" readonly="readonly"/></td>  
        <td><input  value="${student.studentage}"    readonly="readonly"/></td> 
        <td><input  value="${student.studentsex}"    readonly="readonly"/></td> 
        <td><input  value="${student.getClasses().classesname}"    readonly="readonly"/></td> 
    </tr>    
    </c:forEach>  
 </table>
  </body>
</html>
