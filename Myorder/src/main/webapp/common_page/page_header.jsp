<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
	<!-- 主页头部 	公共的  -->
		<ul>
			<li><a href="${pageContext.request.contextPath }/user/find.do"><img src="../img/log1.png"></a></li>
			<li><a href="${pageContext.request.contextPath }/user/find.do" style="color: AliceBlue"><span>首页</span></a></li>
			<li><a href="${pageContext.request.contextPath }/system/showmyOrder.do" ><span>我的订单</span></a></li>
			<!-- 打开新的窗口 target=_blank-->
			<li><a href="../sourceFile/demo1.html" target=_blank ><span>加盟合作</span></a></li>
			<li><a href="#" onclick="toService();"><span>客服中心</span></a></li>
		</ul>
		<div class="nav_right">
			用户名<span id='userID'>${sessionUser.user_name }</span>
			<c:if test="${sessionUser!=null }">
				<a href="${pageContext.request.contextPath }/user/exitUser.do">
					<span>退出</span>
				</a>
			</c:if>		
			<c:if test="${sessionUser==null }">
				<a href="${pageContext.request.contextPath }/system/reg.html">
					<span>登陆</span>
				</a>
			</c:if>		
			<div class="tank" style="display: none">
				<tr>
					<td>个人中心</td>
				</tr>
				<tr>
					<td>我的收藏</td>
				</tr>
				<tr>
					<td>我的地址</td>
				</tr>
			</div>
		</div>
