package com.qudi.service;

import com.qudi.bean.User;
import com.qudi.util.MessageUtil;

/**
 * 用户名service
 * 
 * @author AlanAtlantis
 *
 */
public interface UserDaoService {

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public MessageUtil login(String name, String password, String mobile);

	/**
	 * 注册
	 * 
	 * @param userName
	 * @param password
	 * @param mobile
	 * @return
	 */
	public MessageUtil register(String userName, String password, String mobile);

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	public MessageUtil updateUserInfo(User user);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param userName
	 * @return
	 */
	MessageUtil checkUserName(String userName);

	/**
	 * 检查电话号码是否存在
	 * 
	 * @param mobile
	 * @return
	 */
	MessageUtil checkMobile(String mobile);
}
