package cn.tedu.entity;

import java.io.Serializable;

public class store_comm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//商品id
	private int comm_id;
	//店铺id
	private int store_id;
	//商品图片路径
	private String comm_url;
	//商品名
	private String comm_name;
	//商品单价
	private double comm_price;
	//商品销量
	private int comment_sales;
	
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getComm_url() {
		return comm_url;
	}
	public void setComm_url(String comm_url) {
		this.comm_url = comm_url;
	}
	public String getComm_name() {
		return comm_name;
	}
	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}
	public double getComm_price() {
		return comm_price;
	}
	public void setComm_price(double comm_price) {
		this.comm_price = comm_price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comm_id;
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
		store_comm other = (store_comm) obj;
		if (comm_id != other.comm_id)
			return false;
		return true;
	}
	public int getComment_sales() {
		return comment_sales;
	}
	public void setComment_sales(int comment_sales) {
		this.comment_sales = comment_sales;
	}
	@Override
	public String toString() {
		return "store_comm [comm_id=" + comm_id + ", store_id=" + store_id + ", comm_url=" + comm_url + ", comm_name="
				+ comm_name + ", comm_price=" + comm_price + ", comment_sales=" + comment_sales + "]";
	}
	
		
}
