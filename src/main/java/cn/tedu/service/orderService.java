package cn.tedu.service;

import java.util.List;
import java.util.Map;

public interface orderService {
	
	
	/**
	 * �û����ﳵ���㹦�� �����ύ�Ķ����ַ��� ���в�ֵõ�����
	 * 1.����һ���µĶ�����  ����һ�����ɵ�����ID
	 * 2.��ȡ��ֳ�������Ʒ������+1
	 * 3.��ֺ󽫶�������Ʒ���β��뵽������Ʒ���� 	
	 * @param str
	 * @param user_id
	 * @return
	 */
	int addOrderService(String str,int user_id);
	/**
	  * ���ݵ�½�û�ID��ѯ����
	  * @param userId
	  * @return
	  */
	List<Map<String, String>> selectOrderByUserIdService(Integer userId);
}
