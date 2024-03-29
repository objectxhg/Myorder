<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
<title>商家店铺</title>
<link  type="text/css" rel="stylesheet" href="../css/store.css"/>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../store_js/store.js"></script>
</head>
<body>
	<div class="kk">
	
		<div class="shang" >
			<div class="shang1"></div>
			<div class="shang2" >
				<div class="shang2-1">
					<div class="shang2-2" style="background-image:url(${s.store_url});"></div>
					<div class="shang2-3">
						${s.store_name }
						<span style="display: none">${s.store_id }</span>
						<p>★★★★★</p>
						<h6>(488)</h6>
					</div>
					<div class="shang2-4">
						起送价
						<p>0元</p>
					</div>
					<div class="shang2-5">
						<span>配送费</span>
						<p>配送费￥5</p>
					</div>
					<div class="shang2-6">
						<span>平均送达时间</span>
						<p>38分钟</p>
					</div>
				</div>
			</div>
		</div>
		<div class="zhong">
			<div class="zhong1">
				<p>
					所有商品 <span>|</span>
				</p>
			</div>
			<div class="zhong1-2">
				<p>
					评价<span>|</span>
				</p>
			</div>
			<div class="zhong1-3">
				<p>商家资质</p>
			</div>
			<div class="zhong1-4">
				<div class="zhong1-5">
					<p>默认排序</p>
				</div>
				<div class="zhong1-6">
					<span>评分</span><img src="../img_store/store1/Onbutton.png">
				</div>
				<div class="zhong1-7">
					<span>销量</span><img src="../img_store/store1/Onbutton.png">
				</div>
				<div class="zhong1-8">
					<span>价格</span><img src="../img_store/store1/Onbutton.png">
				</div>
			</div>
			<div class="zhong1-9">
				<img src="../img_store/store1/grid2.png"><img src="../img_store/store1/grid2.png">
			</div>
			<div class="zhong1-10">
				<a href="#"><input title="搜索" type="text"
					placeholder="搜索商家，美食..."></a>
				<div class="zhong1-11">
					<a href="#"><img src="../img_store/store1/search.png"></a>
				</div>
			</div>
		</div>
		<div class="zhong2">
			<ul>
				<li class="zhong2-1"><a href="#"></a><b>热销</b></li>
				<li class="zhong2-2"><a href="#"></a><b>新品上市</b></li>
				<li class="zhong2-3"><a href="#"></a><b>经典主食</b></li>
				<li class="zhong2-4"><a href="#"></a><b>精选小食</b></li>
				<li class="zhong2-5"><a href="#"></a><b>中薯套餐</b></li>
				<li class="zhong2-6"><a href="#"></a><b>鸡翅套餐</b></li>
				<li class="zhong2-7"><a href="#"></a><b>缤纷饮品</b></li>
				<li class="zhong2-8"><a href="#"></a><b>美味甜品</b></li>
				<li class="zhong2-9"><a href="#"></a><b>麦咖啡精选</b></li>
				<li class="zhong2-10"><a href="#"></a><b>麦趣鸡盒</b></li>
				<li class="zhong2-11"><a href="#"></a><b>开心乐园餐</b></li>
			</ul>
			<div class="zhong3">
				<div class="zhong3-1">
					<p>商家公告</p>
				</div>
				<div class="zhong3-2">
					<p>餐厅其中一款网红赞酱—川味赞酱已送完，目前库存酱料有宫保风味赞酱，甜酸酱以及蒜蓉辣椒酱。如有特殊要求烦请备注！！！麦当劳平和堂餐厅喜欢您来，喜欢您再来！</p>
				</div>
			</div>
			<div class="zhong4">
				<span>配送费说明：</span>
				<p>￥5</p>
			</div>
		</div>
		<div class="zhong5">
			<div class="zhong5-1">该商家支持开发票，请在下单时填写好发票抬头</div>
			<div class="zhong5-2">
				<p>
					<a href="#">举报商家</a>
				</p>
			</div>
		</div>
		<div class="zhong6">
			<p>热销</p>
			<h6>大家喜欢吃才叫真好吃</h6>
		</div>
		<div class="zhong7">
			<c:forEach items="${listStore_comm }" var="list">
				<div class="zhong7-1">
					<span style="display: none">${list.comm_id }</span>
					<img src="${list.comm_url }">
					<p>${list.comm_name }</p>
					<div class="zhong7-1-1	">★★★★★</div>
					<h6>月售  <span>${list.comment_sales }</span>+份</h6>
					<div class="zhong7-1-2">￥${list.comm_price }</div>
					<input type="button" value="加入购物车">
				</div>
			</c:forEach>
			<!-- <div style="clear: both"></div> -->
		</div>
		
		
		<!-- <div class="zhong8">
			<div class="zhong8-1">
				<img src="../img_store/m1.png">
				<p>麦辣鸡腿汉堡配麦辣鸡翅套餐</p>
				<div class="zhong8-1-1	">★★★★★</div>
				<h6>(45) 月售300+份</h6>
				<div class="zhong7-1-2">￥33</div>
				<input type="button" value="加入购物车">
			</div>
			<div class="zhong8-2">
				<img src="../img_store/m1.png">
				<p>板烧鸡腿堡配麦辣鸡翅套餐</p>
				<div class="zhong8-2-1	">★★★★★</div>
				<h6>(45) 月售300+份</h6>
				<div class="zhong7-2-2">￥34</div>
				<input type="button" value="加入购物车">
			</div>
			
		</div> -->
		
		<!-- 购物车   style="display: none"-->
		<div class="goods" style="display: none">
				<div class="goods-1">
				<span>购物车 <a href="#" style="text-decoration: none">[清空]</a></span>
				<p style="font-size:14px"></p>
				</div>
				<div class="goods-2"  style="display: none">
				<!-- 	<div class="shops">
						<span>黑椒牛柳铁板饭</span>
						<input type="button" value="-" name=-1>
						<input type="text" readonly="readonly" value="1">
						<input type="button" value="+" name="+1">
						¥<span>29.8</span>
					</div> -->
				</div>
				
				<div class="goods-3">
					<div class="goods-3-1">
						￥<span></span>
					</div>
					<div class="goods-3-2">
						<span>去结算 ></span>
					</div>
				</div>
			</div>
	</div>

</body>
</html>