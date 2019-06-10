package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.User;
import com.qudi.service.UserDaoService;
import com.qudi.service.impl.UserDaoServiceImpl;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDaoService userService;

	/**
	 * 登录
	 * 
	 * @param request
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody MessageUtil login(HttpServletRequest request, @RequestParam String name,
			@RequestParam String password) {
		System.out.println(name + "\t\t" + password);
		MessageUtil me = userService.login(name, password, null);
		if (me.getObject() != null) {
			// 保存登录信息
			request.getSession().setAttribute("user", me.getObject());
			request.getSession().setMaxInactiveInterval(30*60);
		}
		return me;

	}

	/**
	 * ������֤��¼
	 * 
	 * @param request
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/mobileLogin", method = RequestMethod.GET)
	public @ResponseBody MessageUtil mobileLogin(HttpServletRequest request, @RequestParam String mobile) {
		MessageUtil me = userService.login(null, null, mobile);
		if (me.getObject() != null) {
			// ����ѯ���û�����session
			request.getSession().setAttribute("user", me.getObject());
		}
		return me;

	}

	/**
	 * ע��
	 * 
	 * @param userName
	 * @param password
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public @ResponseBody MessageUtil register(@RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("mobile") String mobile) {
		MessageUtil me = userService.register(userName, password, mobile);
		return me;
	}

	/**
	 * .�û���Ϣ�޸�
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateUserInfo(@RequestBody User user) {

		MessageUtil message = userService.updateUserInfo(user);

		return message;
	}

	/**
	 * ����û����Ƿ����
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	public @ResponseBody MessageUtil checkUserName(@RequestParam("userName") String userName) {

		MessageUtil message = userService.checkUserName(userName);

		return message;
	}

	/**
	 * ���绰�����Ƿ����
	 * 
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/checkMobile", method = RequestMethod.GET)
	public @ResponseBody MessageUtil checkMobile(@RequestParam("mobile") String mobile) {

		MessageUtil message = userService.checkUserName(mobile);

		return message;
	}

	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa() {

		return "tables";
	}

}
