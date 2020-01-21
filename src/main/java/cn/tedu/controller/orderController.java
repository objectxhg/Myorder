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
import cn.tedu.service.orderService;

@Controller
@RequestMapping("/system")
public class orderController {
	
	@Resource
	private orderService service;
	
	//�鿴��ʷ����
	@RequestMapping("/showmyOrder.do")
	public String showmyOrder(HttpSession session,ModelMap map){
		User user = (User) session.getAttribute("sessionUser");
		Integer userId = user.getUser_id();
		List<Map<String, String>> orderlist = service.selectOrderByUserIdService(userId);
		map.addAttribute("orderlist", orderlist);
		
		
		return "myOrder";
	}
	
	//�ύ����
	@RequestMapping("/addOrder.do")
	@ResponseBody
	public JsonResult addorder(HttpServletRequest req){
		String comm=req.getParameter("comm");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("sessionUser");
		System.out.println("add:"+user);
		int a = service.addOrderService(comm,user.getUser_id());
		
		return new JsonResult(a);
	}
	
}
