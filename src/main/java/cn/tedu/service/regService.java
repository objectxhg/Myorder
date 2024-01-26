package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.User;

public interface regService {

	public int addUser(String name,String pwd,String phone);

	public User loginUser(String name,String pwd);

	public List<Map<String, Object>> listStore();
}
