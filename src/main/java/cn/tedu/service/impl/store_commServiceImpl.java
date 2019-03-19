package cn.tedu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.dao.store_commDao;
import cn.tedu.entity.store;
import cn.tedu.service.RedisService;
import cn.tedu.service.store_commService;


@Service
public class store_commServiceImpl implements store_commService{
	
	@Resource
	private store_commDao dao;
	
	@Autowired
	RedisService redis;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	//根据店铺Id查询 店铺所有商品信息
	public List<Map<String, Object>> listStore_commService(int store_id) {
		
		List<Map<String, Object>> list = null;
		
		String key = "store_id"+store_id;
		String redisJson = redis.get(key);
		try{
			//判断是否为空  true查询数据库 将对象转为json字符串存入redis
			if(StringUtils.isEmpty(redisJson)){
				list = dao.ListStore_comm(store_id);
				redis.set(key, objectMapper.writeValueAsString(list),100l);
				System.out.println("查询数据库");
			}else{
				list = objectMapper.readValue(redisJson, List.class);
				System.out.println("查询缓存");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	//根据Id查询店铺信息
	public store findStoreServic(int store_id) {

		store s = dao.findStoreDao(store_id);
		
		return s;
	}

	public List<Map<String, Object>> ListComm_ByStoreIdService(int store_id,String div_class) {
		
		//�ж���Ʒ����������
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
	
	
	public List<Map<String, Object>> listStoreByNameService(String storeName) {
		
		store s = new store();
		s.setStore_name(storeName);
		
		return dao.listStoreByName(s);
	}
	
}	



