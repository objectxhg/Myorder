package cn.tedu.entity;

import java.io.Serializable;

public class order_comm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int order_id;
	private int comm_id;
	private int comm_number;
	private double comm_price;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public int getComm_number() {
		return comm_number;
	}
	public void setComm_number(int comm_number) {
		this.comm_number = comm_number;
	}
	public double getComm_price() {
		return comm_price;
	}
	public void setComm_price(double comm_price) {
		this.comm_price = comm_price;
	}
	@Override
	public String toString() {
		return "order_comm [order_id=" + order_id + ", comm_id=" + comm_id + ", comm_number=" + comm_number
				+ ", comm_price=" + comm_price + "]";
	}
	
	
}
