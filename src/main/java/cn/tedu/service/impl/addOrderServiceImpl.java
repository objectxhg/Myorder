package cn.tedu.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.order_FTDao;
import cn.tedu.dao.store_commDao;
import cn.tedu.entity.order_FT;
import cn.tedu.entity.order_comm;
import cn.tedu.entity.store_comm;
import cn.tedu.service.orderService;

@Service
public class addOrderServiceImpl implements orderService{
	
	@Resource
	private order_FTDao orderD;
	@Resource
	private store_commDao commD;

	public int addOrderService(String str,int user_id) {
		System.out.println(str);
		String[] str1 = str.split("@");
		String comms =str1[0]; 
		//��ȡ����ID
		int store_id=Integer.parseInt(str1[1]);
		//��ȡ�����ܼ�
		double order_total = Double.parseDouble(str1[2]);
		System.out.println("�����ܼ�="+order_total);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String time = sim.format(new Date());
		
		order_FT order_ft = new order_FT();
		order_ft.setStore_id(store_id);
		order_ft.setUser_id(user_id);
		order_ft.setOrder_time(time);    
		order_ft.setOrder_total(order_total);
		//��Ӷ���
		int order_id = orderD.addOrder_FTDao(order_ft);
		//��Ŷ�����Ʒ
		List<order_comm> list = new ArrayList<order_comm>();
		//�����Ʒ����
		List<store_comm> saleslist = new ArrayList<store_comm>();
		String[] storecomm = comms.split(",");
		double sum =0;
		for (int i = 0; i < storecomm.length; i+=4) {
			order_comm dcomm = new order_comm();
			store_comm comm = new store_comm();
			//�������ݿⷵ�صĶ�������id
			dcomm.setOrder_id(order_ft.getOrder_id());
			//��һ��Ϊ ��Ʒ����
			int number = Integer.parseInt(storecomm[i]);
			dcomm.setComm_number(number);
			double price = Double.parseDouble(storecomm[i+1]);
			dcomm.setComm_price(price);
			int comm_id = Integer.parseInt(storecomm[i+2]);
			dcomm.setComm_id(comm_id);
			list.add(dcomm);
			
			System.out.println("number"+number);
			comm.setComm_id(comm_id);
			comm.setComment_sales(Integer.parseInt(storecomm[i+3])+number);
			
			saleslist.add(comm);
			sum+=(double)number*price;
		}
		System.out.println(saleslist);
		//���붩����Ʒ��Ϣ
		orderD.addOrder_commDao(list);
		//�޸���Ʒ������Ϣ
		int a =commD.addCommSales(saleslist);
		return a;
	}
	
	
	public List<Map<String, String>> selectOrderByUserIdService(Integer userId) {
		
		return orderD.selectOrderByUserId(userId);
	}

}
