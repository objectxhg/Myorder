$(function(){
	
	//获取店铺ID 跳转到对应的商家店铺
	//$('.zhong5').on('click','.zhongjian-url',toShop);
	$(".zhong1-4").on('click','img',search);
});
	
	function toShop(){
		
		var store_id = $(this).find('span:eq(0)').html();
		
		console.log(1);
	}
		
	function Tank(){
		console.log("Tank");
		$("#tank").show();
	}
	
	function search(){
		alert(1)
	}
	
	
	
	