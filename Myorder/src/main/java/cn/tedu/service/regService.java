package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.User;

public interface regService {
	/**
	 * �����û��� ���� �绰 ע���û�
	 * @param name
	 * @param pwd
	 * @param phone
	 * @return
	 */
	public int addUser(String name,String pwd,String phone);
	/**
	 * �����û��� ������ ��ɵ�½
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User loginUser(String name,String pwd);
	/**
	 * ��·�ɹ�����ʾ��ҳ ��ѯ���еĵ���
	 * @return
	 */
	public List<Map<String, Object>> listStore();
}
