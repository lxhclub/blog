<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页体</title>
</head>
<body style="text-align: center;">
<div id="content" style="margin: 0 auto;width:840px;">
<div id="category" style="float:left;width:200px;border: 1px solid red; text-align: left;height:300px">
分类列表：
    		<ul>		
	    		<c:forEach var="category" items="${categories }">
	    			<li>
	    				<a href="${pageContext.request.contextPath }/client/IndexServlet?method=listGoodsWithCategory&category_id=${category.id}">${category.name }</a>
	    			</li>
	    		</c:forEach>
    		</ul>	
    	</div>
    	<div id="goodsandpage" style="float:left; margin-left:30px;">   		
    		<div id="goods">
    			<c:forEach var="goods" items="${page.list }">
    				<div id="goods" style="height:150; margin-top:20px;">
    					<div id="image" style="float:left;">
    						<img src="${pageContext.request.contextPath }/images/${goods.image}" height=150 width=100>
    					</div>
    					<div id="goodsinfo" style="float:left; text-align:left;">
    						<ul>
    							<li>${goods.name }</li>
    							<li>产地：${goods.field }</li>
    							<li>售价：${goods.price }</li>
    							<li>
    								<a href="${pageContext.request.contextPath }/client/BuyServlet?goodsid=${goods.id}">加入购物车</a>
    							</li>
    						</ul>
    					</div>
    				</div>
    				<div style="clear:both"></div><!-- 做div浮动后，为了不影响后续页面的显示，在这里清楚浮动效果 -->
    			</c:forEach>
    		</div>
    		<div style="clear:both"></div><!-- 做div浮动后，为了不影响后续页面的显示，在这里清楚浮动效果 -->
    		<div id="page" style="margin-top:20px; text-align:center;">
    			当前第[${page.pagenum }]页 &nbsp;&nbsp;
			    <c:forEach var="pagenum" begin="${page.startpage }" end="${page.endpage }">
			    	[<a href="${pageContext.request.contextPath }/client/IndexServlet?method=${param.method }&pagenum=${pagenum}&category_id=${param.category_id}">${pagenum }</a>]
			    </c:forEach>
			    &nbsp;&nbsp;
			    总共[${page.totalpage }]页，共[${page.totalrecord }]条记录
    		</div>
    	</div>
    </div>

</body>
</html>