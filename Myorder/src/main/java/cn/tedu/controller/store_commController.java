package cn.tedu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.JsonResult;
import cn.tedu.entity.store;
import cn.tedu.service.store_commService;

@Controller
@RequestMapping("/store")
public class store_commController {
		
	@Resource
	private store_commService service;
	
	//µÍ∆Ã…Ã∆∑
	@RequestMapping("/listStore_comm.do")
	public String ListStore_commController(HttpServletRequest req){
		
		int store_id = Integer.parseInt(req.getParameter("store_id"));
		List<Map<String, Object>> list = service.listStore_commService(store_id);
		
		store s = service.findStoreServic(store_id);
		System.out.println(s);
		
		req.setAttribute("s", s);
		req.setAttribute("listStore_comm", list);
		
		return "store";
	}
	
	@RequestMapping("/selectComm_ByStoreId.do")
	@ResponseBody
	public JsonResult selectCommController(String store_id,String div_class){
		
		System.out.println(div_class);
		int storeid = Integer.parseInt(store_id);
		List<Map<String,Object>> list = service.ListComm_ByStoreIdService(storeid,div_class);
		
		System.out.println(list);
		
		return new JsonResult(list);
	}
}







