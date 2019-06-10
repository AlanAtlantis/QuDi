package com.qudi.service;

import com.qudi.bean.User;
import com.qudi.util.MessageUtil;

/**
 * �û���service
 * 
 * @author AlanAtlantis
 *
 */
public interface UserDaoService {

	/**
	 * �û���¼
	 * 
	 * @return
	 */
	public MessageUtil login(String name, String password, String mobile);

	/**
	 * ע��
	 * 
	 * @param userName
	 * @param password
	 * @param mobile
	 * @return
	 */
	public MessageUtil register(String userName, String password, String mobile);

	/**
	 * �޸�
	 * 
	 * @param user
	 * @return
	 */
	public MessageUtil updateUserInfo(User user);

	/**
	 * ����û����Ƿ����
	 * 
	 * @param userName
	 * @return
	 */
	MessageUtil checkUserName(String userName);

	/**
	 * ���绰�����Ƿ����
	 * 
	 * @param mobile
	 * @return
	 */
	MessageUtil checkMobile(String mobile);
}
