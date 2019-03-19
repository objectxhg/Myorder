package cn.tedu.service;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	//获取数据
	public String get(String key){
		ValueOperations<String, String>  operations =redisTemplate.opsForValue();
		return operations.get(key);
	}
	
	//插入数据	
	public boolean set(String key,String value){
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		
		try {
			operations.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//插入缓存定义超时时间为秒
	public boolean set(String key,String value,Long expireTime){
		try {
//			TimeUnit.DAYS          天
//			TimeUnit.HOURS         小时
//			TimeUnit.MINUTES       分钟
//			TimeUnit.SECONDS       秒
//			TimeUnit.MILLISECONDS  毫秒

			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			operations.set(key, value, expireTime, TimeUnit.MINUTES);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
