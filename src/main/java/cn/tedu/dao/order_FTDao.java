package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.order_FT;
import cn.tedu.entity.order_comm;

public interface order_FTDao {
	
	
	 int addOrder_FTDao(order_FT order);
	 
	 int addOrder_commDao(List<order_comm> list);
	 
	 List<Map<String, String>> selectOrderByUserId(Integer userId);
} 
