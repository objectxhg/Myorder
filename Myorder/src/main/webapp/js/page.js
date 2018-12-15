$(function(){
	
	//获取店铺ID 跳转到对应的商家店铺
	//$('.zhong5').on('click','.zhongjian-url',toShop);
});
	
	function toShop(){
		
		var store_id = $(this).find('span:eq(0)').html();
		
		console.log(1);
		//location.href='loo.html';只能引导当前页的转向 
		//window.open 打开新的窗口
		/*window.open("http://localhost:8888/Myorder/sourceFile/store.html");*/
	}
		
	function Tank(){
		console.log("Tank");
		$("#tank").show();
	}
	
	
	