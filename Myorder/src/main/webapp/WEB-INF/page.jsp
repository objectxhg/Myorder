<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>饭团网   - 主页</title>
<link rel="stylesheet" type="text/css"  href="../css/my.css"/>
<link rel="stylesheet" type="text/css"  href="../css/page.css" />
<link rel="stylesheet" type="text/css" href="../css/service.css"/>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/page.js"></script>

<script type="text/javascript" src="../js/page_myOrder_Part.js"></script>
<link rel="stylesheet" type="text/css"  href="../css/page1.css" />
</head>
<body>
	
		<div class="zhong">
		<div class="nav">
			<%@ include file="../common_page/page_header.jsp" %>
		</div>
		<input type="hidden" value="${name }" id="h_id">
		<script type="text/javascript">
			//加载 共有的header模块页面
			//想要在load里面的页面上绑定方法 只能在load的回调函数里面绑定
			/*  $(".nav").load("../common_page/page_header.jsp",function(){
				$(".nav_right img").mouseover(Tank);
				var name = $('#h_id').val();
				
				$('#userID').html(name);
			}); */ 
				
		</script>
		
		<div class="page">
		<div class="page_common">
		<div class="city">
			<i>当前位置：</i><a>建鸿达现代城 </a><span><a href="#">[切换地址]</a></span>
		</div>
		<div class="zhong1-3">
			<a href="#"><input title="搜索" type="text"
				placeholder="搜索商家，美食..."></a>
			<div class="zhong1-4">
				<a href="#"><img src="../img_page/sou.png"></a>
			</div>
		</div>
		<div class="zhong2">
			<img src="../img_page/tu.png">
		</div>
		<div class="zhong3">
			<div class="zhong3_1">
				<p>商品分类：</p>
			</div>
			<div class="zhong3_2">
				<ul>
					<li class="zhong4-1"><a href="#">全部商家</a></li>
					<li class="zhong4-2"><a href="#">美食</a></li>
					<li class="zhong4-3"><a href="#">快餐便当</a></li>
					<li class="zhong4-4"><a href="#">特色菜系</a></li>
					<li class="zhong4-5"><a href="#">异国料理</a></li>
					<li class="zhong4-6"><a href="#">小吃夜宵</a></li>
					<li class="zhong4-7"><a href="#">甜品饮品</a></li>
					<li class="zhong4-8"><a href="#">果蔬生鲜</a></li>
					<li class="zhong4-9"><a href="#">商店超市</a></li>
					<li class="zhong4-10"><a href="#">鲜花绿植</a></li>
					<li class="zhong4-11"><a href="#">医药健康</a></li>
					<li class="zhong4-12"><a href="#">早餐</a></li>
					<li class="zhong4-13"><a href="#">午餐</a></li>
					<li class="zhong4-14"><a href="#">下午茶</a></li>
					<li class="zhong4-15"><a href="#">晚餐</a></li>
					<li class="zhong4-16"><a href="#">夜宵</a></li>
				</ul>
			</div>
		</div>
		<div class="zhong5">
		
		<c:forEach items="${listStore}" var="list">
			<a href="${pageContext.request.getContextPath()}/store/listStore_comm.do?store_id=${list.store_id }" target="_blank" >
				<div class="zhongjian">
					<div class="zhongjian-url">
					<span style="display: none"></span>
					<img src="${list.store_url }"> 
					<span>${list.store_name }</span> 
					</div>
					<img class="qqimg" src="../img_page/single.png">
					<p>配送费3.5</p>
				</div>
			</a>
		</c:forEach>
		
			<div style="clear: both"></div>
		</div>
			<div style="background-color: #e6e6e6">
				<a id="loding">加载更多商家.</a>
			</div>
		</div>
		</div>
			
		<div>
			<div class="zhouqi">
				<ul>
					<li><h4>
							<a href="#">用户帮助</a>
						</h4></li>
					<li><a>我的客服</a></li>
				</ul>
			</div>
			<div class="z1">
				<ul>
					<li><h4>
							<a href="#">商务合作</a>
						</h4></li>
					<li><a href="#">我要开店</a></li>
					<li><a href="#">加盟指南</a></li>
					<li><a href="#">市场合作</a></li>
					<li><a href="#">开放平台</a></li>
				</ul>
			</div>
			<div class="z1">
				<ul>
					<li><h4>
							<a href="#">关于我们</a>
						</h4></li>
					<li><a href="#">饭团网介绍</a></li>
					<li><a href="#">加入我们</a></li>
					<li><a href="#">联系我们</a></li>
					<li><a href="#">规则中心</a></li>
				</ul>
			</div>

			<div class="s1">
				<a>24小时客服热线：10105757</a> 
				<a> 关于我们：
					<img alt=""
					src="${pageContext.request.getContextPath()}/img_page/wechat.png"> 
					<img alt=""
					src="${pageContext.request.getContextPath()}/img_page/sinablog.png">
				</a>
			</div>

			<div class="b1">
				<img src="${pageContext.request.getContextPath()}/img_page/erw.png">

				<div class="d">
					<a href="#">下载手机版本</a>

					<h4>
						<a>扫一扫,手机订餐方便。</a>
					</h4>
				</div>
			</div>
		</div>
	</div>
</body>
</html>