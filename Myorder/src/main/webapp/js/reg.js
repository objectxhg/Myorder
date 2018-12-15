$(function(){
	//添加点击事件
	console.log($(".img_reg").html());
	/*$("#reg").click(RegAction);
	$("#login").click(LoginAction);*/
});


function chckUser(user){
	var str = 	/^[a-z0-9_-]{3,16}$/;
	if (str.test(user)) {
		return true;
	}
		return false;
}

function chckPwd(pwd){
	var str = 		/^[a-z0-9_-]{6,18}$/;
	if (str.test(user)) {
		return true;
	}
		return false;
}

function chckPhone(phone){
	var str = 	/^\d{11}$/;
	if (str.test(user)) {
		return true;
	}
		return false;
}

//注册
function RegAction(){
	
	
	console.log("RegAction");
	
	var user = $('#user').val().trim();
	var pwd = $('#pwd').val().trim();
	var phone = $('#phone').val().trim();
	
	var s = chckUser(user)+chckUser(pwd)+chckUser(phone);
	
	if (s!=3) {
		console.log("账号或密码手机填写错误");
		return;
	}
		var data = {'name':user,
					'pwd':pwd,
					'phone':phone
		};
		console.log(s);
		$.ajax({
			url:'../user/reg.do',
			data:data,
			type:'post',
			dataType:'json',
			success:function(result){
				if (result.state==0) {
					console.log("注册成功");
					tospan_log();
				}
			},
			error:function(){
				alert("注册失败 通信异常");
			}
		});
	}
//登陆
function LoginAction(){
	
	var user = $("#user").val().trim();
	var pwd = $("#pwd").val().trim();
	
	var data = {
			'name':user,
			'pwd':pwd
	};
	
	$.ajax({
		url:'../user/login.do',
		data:data,
		type:'post',
		dataType:'json',
		success:function(result){
			var data = result.data;
			var name = data.user_name;
			alert("登陆成功");
			
			location.href='../user/find.do';
		},
		error:function(){
		}
	});
	
	
	
}
function tospan_reg(){
	$(".part").remove();
	$(".reg_login").load("../common_reg/reg_part.html");
}
function tospan_log(){
	$(".part").remove();
	$(".reg_login").load("../common_reg/login_part.html");
}










