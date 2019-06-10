package com.qudi.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.User;
import com.qudi.dao.UserDao;
import com.qudi.service.UserDaoService;
import com.qudi.util.MD5Util;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("userService")
public class UserDaoServiceImpl implements UserDaoService {

	@Autowired
	private UserDao userDao;

	public MessageUtil login(String name, String password, String mobile) {

		if (password != null) {
			// md5 encryption
			password = MD5Util.getMD5(password);
		}

		MessageUtil message = new MessageUtil();

		// Query login information
		User user = userDao.login(name, password, mobile);

		// Determine if the login was successful
		if (user != null) {
			message.setResult(Result.SUCCEED);
			message.setObject(user);
			message.setInfo("Login successful");
			return message;
		}
		message.setInfo("Login failed, login information error");
		return message;
	}

	public MessageUtil register(String userName, String password, String mobile) {

		MessageUtil message = new MessageUtil();
		/*
		 * int id = userDao.checkUserName(userName).getId(); if (id == 0) {
		 * message.setInfo("�û����Ѵ���"); return message; }
		 */
		if (userName != null && userName.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in the user name");
			return message;
		}
		if (password != null && password.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in the password");
			return message;
		}
		if (mobile != null && mobile.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in your mobile phone number");
			return message;
		}

		// encryption
		password = MD5Util.getMD5(password);
		User user = new User();

		user.setUserName(userName);
		user.setPassword(password);
		user.setMobile(mobile);

		if (userDao.register(user) > 0) {
			message.setInfo("Registered successfully");
			message.setResult(Result.SUCCEED);
			return message;
		}
		message.setInfo("Registration failed");
		return message;
	}

	public MessageUtil updateUserInfo(User user) {
		MessageUtil message = new MessageUtil();

		if (user == null) {
			message.setInfo("Parameter error");
			return message;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 
		String updateTime = df.format(new Date()).toString();// new Date()Ϊ��ȡ��ǰϵͳʱ��

		user.setUpdateTime(updateTime);

		if (userDao.updateUserInfo(user) > 0) {
			message.setInfo("Modify the success");
			message.setResult(Result.SUCCEED);
			return message;
		}
		message.setInfo("Modify the failure");
		return message;
	}

	public MessageUtil checkUserName(String userName) {
		MessageUtil message = new MessageUtil();
		if (userName != null) {
			// Check if the user name exists
			User user = userDao.checkUserName(userName);

			if (user != null) {
				message.setInfo("Username available");
				return message;
			}
			message.setInfo("User name unavailable");
			message.setResult(Result.SUCCEED);
			return message;
		}
		message.setInfo("Parameter error");
		return message;
	}

	public MessageUtil checkMobile(String moblie) {
		MessageUtil message = new MessageUtil();
		if (moblie != null) {
			// Check phone Numbers
			User user = userDao.checkMobile(moblie);

			if (user != null) {
				message.setInfo("Telephone number available");
				return message;
			}
			message.setInfo("The telephone number is not available");
			message.setResult(Result.SUCCEED);
			return message;
		}
		message.setInfo("Parameter error");
		return message;
	}
}
