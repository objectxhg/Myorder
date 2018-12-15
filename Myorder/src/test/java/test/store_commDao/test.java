package test.store_commDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.order_FTDao;
import cn.tedu.dao.store_commDao;
import cn.tedu.entity.store_comm;

public class test {
	
	@Test
	public void test(){
	 AbstractApplicationContext app =new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
	
	store_commDao dao = app.getBean("store_commDao",store_commDao.class);
	List<store_comm> list = new ArrayList<store_comm>();
	store_comm comm = new store_comm();
	comm.setComm_id(4);
	comm.setComment_sales(45);
	list.add(comm);
	System.out.println(list);
	dao.addCommSales(list);
	}
	
	@Test
	public void test2(){
		AbstractApplicationContext app =new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		order_FTDao dao = app.getBean("order_FTDao",order_FTDao.class);
		List<Map<String, String>> list = dao.selectOrderByUserId(1);
		System.out.println(list);
	}
}
