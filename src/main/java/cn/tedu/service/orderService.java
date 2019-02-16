package cn.tedu.service;

import java.util.List;
import java.util.Map;

public interface orderService {
	
	
	/**
	 * 用户购物车结算功能 根据提交的订单字符串 进行拆分得到数据
	 * 1.插入一条新的订单表  返回一个生成的主键ID
	 * 2.获取拆分出来的商品月销量+1
	 * 3.拆分后将订单订商品批次插入到订单商品表中 	
	 * @param str
	 * @param user_id
	 * @return
	 */
	int addOrderService(String str,int user_id);
	/**
	  * 根据登陆用户ID查询订单
	  * @param userId
	  * @return
	  */
	List<Map<String, String>> selectOrderByUserIdService(Integer userId);
}
