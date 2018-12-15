package cn.tedu.entity;

import java.io.Serializable;

public class order_FT implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int loding = 0;
	private static final int ok = 1;
	private static final int cancel = 2;


	//订单ID主键
	private int order_id;
	//店铺ID
	private int store_id;
	//用户ID
	private int user_id;
	//订单时间
	private String order_time;
	//订单总价
	private double order_total;
	
	/**
	 * 订单状态 0:订单商品正在配送中 
	 * 		 1:订单商品已送达
	 * 		 2:订单商品已取消
	 */
	private int order_state = loding;
	
	
	public void setOrder_state(int order_state) {
		if(order_state>=1 && order_state<=2){
			this.order_state = order_state;
		}else{
			throw new RuntimeException("未知的订单状态!(0-2)");
		}
		
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public int getOrder_state() {
		return order_state;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_tota) {
		this.order_total = order_tota;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		order_FT other = (order_FT) obj;
		if (order_id != other.order_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "order_FT [order_id=" + order_id + ", store_id=" + store_id + ", user_id=" + user_id + ", order_time="
				+ order_time + ", order_total=" + order_total + ", order_state=" + order_state + "]";
	}
}
