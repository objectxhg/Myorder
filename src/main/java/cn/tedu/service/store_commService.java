package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.store;


public interface store_commService {
		
		public List<Map<String, Object>> listStore_commService(int store_id);
		
		public List<Map<String, Object>> ListComm_ByStoreIdService(int store_id,String div_class);
		
		public store findStoreServic(int store_id);
		
		public List<Map<String,Object>> listStoreByNameService(String storeName);

}
