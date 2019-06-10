package com.qudi.dao;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.User;

public interface UserDao {

	User queryName(int id);

	/**
	 * ��¼
	 * 
	 * @param userName
	 * @param password
	 * @param mobile
	 * @return
	 */
	User login(@Param("userName") String userName, @Param("password") String password, @Param("mobile") String mobile);

	/**
	 * ע��
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * �޸�
	 * 
	 * @param user
	 * @return
	 */
	int updateUserInfo(User user);

	/**
	 * �ж��û����Ƿ�ռ��
	 * 
	 * @param userName
	 * @return
	 */
	User checkUserName(@Param("userName") String userName);

	/**
	 * ����û����Ƿ����
	 * 
	 * @param mobile
	 * @return
	 */
	User checkMobile(@Param("mobile") String mobile);

}
