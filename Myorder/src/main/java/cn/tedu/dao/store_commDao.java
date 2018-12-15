package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.entity.store;
import cn.tedu.entity.store_comm;

public interface store_commDao {
		
	public List<Map<String, Object>> ListStore_comm(int store_id);
	
	public List<Map<String, Object>> ListComm_ByStoreIdDao(@Param("store_id")int store_id,
														   @Param("conditions")String conditions);
	
	public store findStoreDao(int store_id);
	
	public int addCommSales(List<store_comm> list);
	
}	
