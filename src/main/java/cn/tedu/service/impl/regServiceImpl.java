package cn.tedu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.dao.loginDao;
import cn.tedu.entity.User;
import cn.tedu.service.regService;

@Service
public class regServiceImpl implements regService{
	
	@Resource
	private loginDao dao;
	
	@Value("#{jdbc.salt}")
	private String str;
	
	public int addUser(String name,String pwd,String phone) {
		
		if(name.trim().isEmpty()){
			System.out.println("name����Ϊ��");
		}
		if(pwd.trim().isEmpty()){
			System.out.println("pwd����Ϊ��");
		}
		if(phone.trim().isEmpty()){
			System.out.println("phone����Ϊ��");
		}
		
		//pwd = DigestUtils.md5Hex(str+pwd);
		System.out.println(pwd);
		double money =2000;
		int a = dao.regDao(name,pwd,phone,money);
		
		return a;
	}

	public User loginUser(String name,String pwd) {
		
		if(name.trim().isEmpty()){
			System.out.println("用户名不能为空");
		}
		User user = dao.login(name);
		System.out.println(user);
		if(user==null){
			throw new RuntimeException("用户名错误");
		}
		if(pwd.equals(user.getUser_pwd())){
			return user;
		}
		throw new RuntimeException("密码错误");
		
	}

	public List<Map<String, Object>> listStore() {
		
		List<Map<String, Object>> list = dao.listStore();
		System.out.println(list);
		
		return list;
	}
	
}
