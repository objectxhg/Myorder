package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.entity.User;
public interface loginDao {
	
	//зЂВс
	public int regDao(@Param("name")String name,
			          @Param("pwd")String pwd,
			          @Param("phone")String phone,
			          @Param("money")double money);
	
	public User login(String name);
	
	public List<Map<String, Object>> listStore();
	
}
