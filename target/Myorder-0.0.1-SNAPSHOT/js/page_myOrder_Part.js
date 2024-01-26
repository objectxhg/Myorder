function tomyOrder(){
	$(".page_common").remove();
	$(".page").load("../common_myOrder/page_myOrder_Part.html");
}
function toService(){
	$(".page_common").remove();
	$(".page").load("../common_myOrder/page_service_Part.html");
}



function Moeny(){
	
	//Ajax先请求数据 
	$(".part").remove();
	$(".p_right").load("../common_page/moeny_Part.html")
		
}
function address(){
	$(".part").remove();
	$(".p_right").load("../common_page/address_Part.html");
}
function personalData(){
	$(".part").remove();
	$(".p_right").load("../common_page/personalData_Part.html");
}
//查看历史订单
function my(){
	$(".part").remove();
	$(".p_right").load("../common_page/myOrder_Part.html",function(){
		$.ajax({
			url:"../system/showAllOrderByUid.do",
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.state==0){
					var data = result.data;
					for(var i = 1;i<data.length;i++){
						var order = '<tr>'
									'+<td>[id]</td>'
									'+<td>[url]</td>'
									'+<td>[time]</td>'
									'+<td>[total]</td>'
									'+<td>[state]</td>'
									'+</tr>';
						
						order.replace("[id]",data[i].order_id)
							 .replace("[url]",data[i].store_url)
						 	 .replace("[time]",data[i].store_time)
						 	 .replace("[total]",data[i].store_total);
										
						//订单状态 0：正在派送	 1：订单已完成    2：订单已取消
						if(data[i].order_state==0){
							order.replace("[state]","订单正在派送中");
						}else if(data[i].order_state==1){
							order.replace("[state]","订单已完成");
						}else if(data[i].order_state==2){
							order.replace("[state]","订单已取消");
						}
						$("#order-table").append(order);
					}
				}
			}
		});
		
	});
}
function center(){
	$(".part").remove();
	$(".p_right").load("../common_page/my_Part.html");
}