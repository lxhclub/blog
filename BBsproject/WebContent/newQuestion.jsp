<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>��������</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  
<body>
	<center>
		<%@ include file="top.jsp" %>
		<div id="wholePage">
			<div id="currentPoint">
				��ǰλ��:&nbsp;&nbsp;<a class="green" href="action/allQuestionAction.action">��ҳ</a>&nbsp;&nbsp;--&gt;&nbsp;&nbsp;���������
			</div>				
			<h1>��������</h>
			<hr width="400"/>
			<s:form action="addQuestionAction" method="post">
				<s:property value="prompt"/>
				<s:textfield label="����" name="question.topic" maxlength="50" cssStyle="width:200px;"></s:textfield>
				<s:textarea label="����" name="question.matter" rows="10" cols="50"></s:textarea>
				<s:submit value="����"></s:submit>
			</s:form>
		</div>
		<%@ include file="bottom.html" %>
	</center>
</body>
</html>