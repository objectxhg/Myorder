package cn.tedu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.store_commDao;
import cn.tedu.entity.store;
import cn.tedu.entity.store_comm;
import cn.tedu.service.store_commService;


@Service
public class store_commServiceImpl implements store_commService{

	@Resource
	private store_commDao dao;
	
	public List<Map<String, Object>> listStore_commService(int store_id) {
		
		List<Map<String, Object>> list = dao.ListStore_comm(store_id);
		
		return list;
	}

	public List<Map<String, Object>> ListComm_ByStoreIdService(int store_id,String div_class) {
		
		//判断商品的排序条件
		String conditions = "";
		if("zhong1-7".equals(div_class)){
			conditions = "comment_sales";
		}
		if("zhong1-8".equals(div_class)){
			conditions = "comm_price";
		}
		System.out.println("conditions:"+conditions);
		List<Map<String, Object>> list = dao.ListComm_ByStoreIdDao(store_id,conditions);
		return list;
	}
	
	
	public store findStoreServic(int store_id) {

		store s = dao.findStoreDao(store_id);
		
		return s;
	}
	
}	



