package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.User;

public interface regService {
	/**
	 * 根据用户名 密码 电话 注册用户
	 * @param name
	 * @param pwd
	 * @param phone
	 * @return
	 */
	public int addUser(String name,String pwd,String phone);
	/**
	 * 根据用户名 和密码 完成登陆
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User loginUser(String name,String pwd);
	/**
	 * 等路成功后显示主页 查询所有的店铺
	 * @return
	 */
	public List<Map<String, Object>> listStore();
}
