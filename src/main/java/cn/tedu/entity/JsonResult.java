package cn.tedu.entity;

import java.io.Serializable;

import javafx.print.JobSettings;

public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	
	private int state;
	private String message;
	private Object data;
	/**
	 * 
	 * 正常返回数据
	 * @param data
	 */
	public JsonResult(Object data){
		this.data = data;
		this.state = SUCCESS;
	}
	public JsonResult(int a,Throwable e){
		this.message=e.getMessage();
		this.state = ERROR;
	}
	public JsonResult(Throwable e){
		this.message = e.getMessage();
		this.state = ERROR;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + state;
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
		JsonResult other = (JsonResult) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}



	public JsonResult(Object data, int state){
		
	}
	
}
