<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">

<div class="personal">
	<div class="p_left">
		<ul>
			<li id="li1">
				<h2>
					<span class="iconfont">&#xe6a3;</span><a href="#"
						onclick="center();">个人中心</a>
				</h2>
			</li>
			<li><h2>
					<span class="iconfont">&#xe68e;</span>&nbsp;<span id="label1">我的订单</span>
				</h2></li>
			<li><a
				href="${pageContext.request.contextPath }/system/showAllOrderByUid.do">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近期订单</a>
			<li>
			<li><h2>
					<span class="iconfont">&#xe71d;</span>&nbsp;我的资产
				</h2></li>
			<li><a onclick="Moeny();" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的余额</a>
			<li>
			<li><h2>
					<span class="iconfont">&#xe61e;</span>&nbsp;我的资料
				</h2></li>
			<li><a onclick="personalData();" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人资料</a>
			<li>
			<li><a onclick="address();" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址管理</a>
			<li>
			<li><h2>
					<span class="iconfont">&#xe725;</span>&nbsp;我的收藏
				</h2></li>
		</ul>
	</div>

	<div class="p_right">
		<div id="r_top">
			<div id="r_top_l">
				<div class="r_top_l-d">
					<span id="r_top_span">近期订单</span>
				</div>
				<div id="order-table">
					<table>
						<tr>
							<td>订单店铺</td>
							<td>店铺名</td>
							<td>订单时间 </td>
							<td>订单金额 </td>
							<td>订单状态 </td>
							<td>订详情页 </td>
						</tr>
						<c:forEach items="${orderlist }" var="order">
							<tr>
								<td><img src="${order.store_url }"></td>
								<td>${order.store_name }</td>
								<td>${order.order_time }</td>
								<td>${order.order_total }</td>
								<td >
									<c:if test="${order.order_state==0 }">正在派送..</c:if>
									<c:if test="${order.order_state==1 }">订单已送达</c:if>
									<c:if test="${order.order_state==2 }">订单已取消</c:if>
								</td>
								<td><a href="../system/showOrder.do?order_id="${order.order_id }>订单详情</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</div>
	</div>

</div>

