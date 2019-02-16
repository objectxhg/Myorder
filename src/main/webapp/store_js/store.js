$(function(){
	
	//点击显示购物车并添加物品
	$(".zhong7").on("click",":button",addGoods);
	//清空购物车
	$(".goods-1 a").click(emptyGoods)
	
	//购物车+-
	$(".goods").on("click",":button",add_cut);
	
	//结算
	$(".goods-3-2").on("click","span",settlement);

	//商品排序
	$('.zhong1-4').on("click","div",sales_BystoreId);
	
})	
	
	function sales_BystoreId(){
		
		var cls = $(this).attr('class');
			
		var store_id = $('.shang2-3').find('span').html();
		var data = {'store_id':store_id,'div_class':cls};
		console.log(data);
		
		var comm = '<div class="zhong7-1">'
			+'<span style="display: none">[comm_id]</span>'
			+'<img src="[comm_url]">'
			+'<p>[comm_name]</p>'
			+'<div class="zhong7-1-1	">★★★★★</div>'
			+'<h6>月售  <span>[comment_sales]</span>+份</h6>'
			+'<div class="zhong7-1-2">￥[comm_price]</div>'
			+'<input type="button" value="加入购物车">'
			+'</div>';
		
		$.ajax({
			url:'../store/selectComm_ByStoreId.do',
			data:data,
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.state==0) {
					var list = result.data;
					$('.zhong7').html("");
					for(var i=0; i<list.length;i++){
						console.log(list[i]);
						$('.zhong7').append(comm.replace('[comm_id]',list[i].comm_id)
											    .replace('[comm_url]',list[i].comm_url)
											    .replace('[comm_name]',list[i].comm_name)
											    .replace('[comment_sales]',list[i].comment_sales)
											    .replace('[comm_price]',list[i].comm_price));
					}
				}
			},
			error:function(){
				alert("通信异常");
			}
		});
		
	}


	
	function settlement(){
		//总价
		var total = $('.goods-3-1').find('span').html();
		if(total=='0'){
			alert("购物车里还什么都没有哦~");
			return;
		}
		
		var comm = "";
		var bill = $(".goods-3-1").find("span").html();
		var goods = $('.goods-2').children();
		for(var i =0;i<goods.length;i++){
			//var title = $(goods[i]).find('span:eq(0)').html();
			var number = $(goods[i]).find('input:eq(1)').val();
			var price = $(goods[i]).find('span:eq(1)').html();
			var comm_id = $(goods[i]).find('span:eq(3)').html();
			var comment_sales = $(goods[i]).find('span:eq(4)').html();
			if(comm.length>0){
				comm+=',';
			}
			
			comm+=number+','+price+','+comm_id+','+comment_sales;
		}
		//最后面追加一个店铺ID
		var store_id = $('.shang2-3').find('span').html();
		
		comm+='@'+store_id+'@'+total;
		console.log(comm);
		$.ajax({
			url:'../system/addOrder.do',
			data:{'comm':comm},
			//{"comm":JSON.stringify(data)},
			type:'post',
			dataType:'json',
			traditional:true,
			success:function(result){
				var state = result.state;
				alert(state);
				emptyGoods();
			},
			error:function(){
				alert("通信异常");
				location="../system/reg.html";
			}
		});
			//刷新页面
			window.location.reload();
			
	}

	function sum_shops(){
		console.log("sum_shops");
		var shops = $(".goods-2").children();
		var sum =0;
		for(var i =0;i<shops.length;i++){
			var a= parseInt($(shops[i]).find("span:eq(2)").html());
			sum+=a;
		}
		$(".goods-3-1").find("span").html(sum);
	}

	function addGoods(){
		$(".goods-1").find('p').html("");
		
		var a =1;
		console.log("添加购物车");
		
		var shops = '<div class="shops">'
			+'<span>[title]</span>'
			+'<span style="display: none">[price]</span>'
			+'<input type="button" value="-">'
			+'<input type="text" readonly="readonly" value='+a+'>'
			+'<input type="button" value="+">'
			+'¥<span>[sum]</span>'
			+'<span style="display: none">[comm_id]</span>'
			+'<span style="display: none">[comment_sales]</span>'
			+'</div>';
		
		var title =$(this).parent().find('p').html();
		var price = $(this).prev().html().split('￥')[1];
		var comm_id = $(this).parent().find('span').html();
		var comment_sales = $(this).siblings('h6').find('span').html();
		if($(".goods").css("display")=="none"){
			
				$(".goods").show().css("top","481px");
			
			$(".goods-2").fadeIn()
			.append(shops.replace('[title]',title).replace('[price]',price)
			.replace('[sum]',price*a).replace('[comm_id]',comm_id)
			.replace('[comment_sales]',comment_sales));
			
		}else{
			
			if($(".goods-2").css("display")=="none"){
				$(".goods").show().css("top","480px");
				
				//判断是否为购物车是否存在
				
				$(".goods-2").fadeIn()
				.append(shops.replace('[title]',title).replace('[price]',price)
				.replace('[sum]',price*a).replace('[comm_id]',comm_id)
				.replace('[comment_sales]',comment_sales));
			}else{
				var goods = $('.goods-2').children();
				for(var i =0;i<goods.length;i++){
					var t = $(goods[i]).find('span:eq(0)').html();
						
					if(title==t){
						var val = $(goods[i]).find('input:eq(1)').val();
						var sum =parseInt(val)+1;
						$(goods[i]).find('input:eq(1)').val(sum);
						$(goods[i]).find('span:eq(2)').html((sum*price).toFixed(2));
						//如果存在 数量+1 退出程序  JS里面 return是退出整个方法
						sum_shops();
						return;
					}
				}
				//for循环遍历完后 走这 说明不存在相同商品 在购物车添加新一栏商品
				var t = $(".goods").css("top").replace("px","");
				t = parseInt(t)-40;
				$(".goods").show().css("top",t+"px");
				var height= $(".goods-2").css("height").replace("px","");
				height = parseInt(height)+40;
				var height= $(".goods-2").css("height",height+"px");
				//在选中元素末尾添加
				$(".goods-2").fadeIn()
				.append(shops.replace('[title]',title).replace('[price]',price)
				.replace('[sum]',price*a).replace('[comm_id]',comm_id)
				.replace('[comment_sales]',comment_sales));
				
			}
		}
		sum_shops();
	}
	//每次加入购物车的格式
	
	function emptyGoods(){
		console.log("清空购物车");
		$(".goods-2").hide().html("").css("height","42px");
		$(".goods-1").find('p').html("购物车里什么都没有哦~~ 赶快来添加吧");
		$(".goods").css("top","524px");
		$(".goods").css("height","94px");
		$(".goods-3-1").find("span").html("0");
	}
	
	function add_cut(){
		var input = $(this);
		console.log(input.val());
		
		if(input.val()=="-"){
			var text = $(this).next().val();
			if(text-1>0){
				$(this).next().val(--text);
				var sum =parseInt($(this).parent().find("span:eq(1)").html());
				$(this).parent().find("span:eq(2)").html(sum*text);
			}else if(text-1==0){
				$(this).parent().remove();
				
				$(".goods").show().css("top",481+"px");
				var height= $(".goods-2").css("height").replace("px","");
				height = parseInt(height)-40;
				var height= $(".goods-2").css("height",height+"px");
			}
			
		}else if(input.val()=="+"){
			var text = $(this).prev().val();
			$(this).prev().val(++text);
			var sum =parseInt($(this).parent().find("span:eq(1)").html());
			$(this).parent().find("span:eq(2)").html(sum*text);
		}
		sum_shops();
	}
	