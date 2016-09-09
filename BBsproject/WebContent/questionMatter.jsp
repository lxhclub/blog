<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title><s:property value="post.topic"/></title>
	<link rel="stylesheet" type="text/css" href="../css/styles.css">
  </head>
  
<body>
	<center>
		<%@ include file="top.jsp" %>
		<div id="wholePage">
			<div id="currentPoint">
				当前位置:&nbsp;&nbsp;<a class="green" href="allQuestionAction.action">首页</a>&nbsp;&nbsp;--&gt;&nbsp;&nbsp;<s:property value="question.topic"/>
			</div>
			<hr width="400"/>
			<ul class="questionMatter">
				<li class="questionTopic">
					标题：<s:property value="question.topic"/>
				</li>
				<li class="questionAuthor">
					作者：<a class="green" href="userInformationAction.action?userId=<s:property value="question.user.userId"/>"><s:property value="question.user.userNickname"/></a>
				</li>
				<li class="authorPoints">
					积分：<s:property value="question.user.userPoints"/>
				</li>
				<li class="postTime">
					时间：<s:date name="question.postTime" format="yyyy-MM-dd HH:mm:ss"/>
				</li>
				<li class="questionMatter">
					内容: <textarea rows="10" cols="50" readonly="readonly" style="vertical-align: top"><s:property value="question.matter"/></textarea>
				</li>
			</ul>
		</div>
		<%@ include file="bottom.html" %>
	</center>
</body>
</html>
