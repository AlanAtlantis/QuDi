package com.qudi.dao;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.User;

public interface UserDao {

	User queryName(int id);

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @param mobile
	 * @return
	 */
	User login(@Param("userName") String userName, @Param("password") String password, @Param("mobile") String mobile);

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	int updateUserInfo(User user);

	/**
	 * 判断用户名是否被占用
	 * 
	 * @param userName
	 * @return
	 */
	User checkUserName(@Param("userName") String userName);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param mobile
	 * @return
	 */
	User checkMobile(@Param("mobile") String mobile);

}
