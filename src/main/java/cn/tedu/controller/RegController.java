package cn.tedu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.JsonResult;
import cn.tedu.entity.User;
import cn.tedu.service.regService;

@Controller
@RequestMapping("/user")
public class RegController {
	
	@Resource
	private regService service;
	
	//ÍË³ö
	@RequestMapping("/exitUser.do")
	public String ExitUser(HttpSession session){
		session.removeAttribute("sessionUser");
		
		return "redirect:../user/find.do";
	}
	//×¢²á
	@RequestMapping("/reg.do")
	@ResponseBody
	public JsonResult Regcontroller(String name,String pwd,String phone){
		int a = service.addUser(name, pwd, phone);
		System.out.println(a);
		return new JsonResult(a);
	}
	//µÇÂ½
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult Logincontroller(String name,String pwd,HttpServletRequest req){
		User user = service.loginUser(name, pwd);
		
		HttpSession session = req.getSession();
		session.setAttribute("sessionUser", user);
		
		return new JsonResult(user);
	}
	//Ö÷Ò³
	@RequestMapping("/find.do")
	public String listStoreController(ModelMap map){
		List<Map<String, Object>> list = service.listStore();
		map.addAttribute("listStore",list);
		
		return "page";
	}
	
}
