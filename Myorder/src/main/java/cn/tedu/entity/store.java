package cn.tedu.entity;

import java.io.Serializable;

public class store implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int store_id;
	private String store_name;
	private String store_url;
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_url() {
		return store_url;
	}
	public void setStore_url(String store_url) {
		this.store_url = store_url;
	}
	@Override
	public String toString() {
		return "store [store_id=" + store_id + ", store_name=" + store_name + ", store_url=" + store_url + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + store_id;
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
		store other = (store) obj;
		if (store_id != other.store_id)
			return false;
		return true;
	}
	
}

