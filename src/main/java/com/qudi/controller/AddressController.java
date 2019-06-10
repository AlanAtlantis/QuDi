package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.Address;
import com.qudi.bean.User;
import com.qudi.service.AddressDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressDaoService addressService;

	/**
	 * 查单个地址
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryAddress", method = RequestMethod.GET)
	public @RespectBinding MessageUtil queryAddress(@RequestParam("id") int id) {
		// 调用查询方法根据id查询
		MessageUtil message = addressService.queryAddress(id);
		return message;
	}

	/**
	 * 查询用所有地址
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/queryAddressList", method = RequestMethod.GET)
	public @RespectBinding MessageUtil queryAddressList(@RequestParam("userId") int userId) {
		// 根据用户id查询
		MessageUtil message = addressService.queryAddressList(userId);
		return message;
	}

	/**
	 * 添加地址
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/insertAddress", method = RequestMethod.GET)
	public @RespectBinding MessageUtil insertAddress(@RequestBody Address address, HttpServletRequest request) {
		// 调用添加方法
		User u = (User) request.getSession().getAttribute("user");
		MessageUtil message = addressService.insertAddress(address, u.getId());
		return message;
	}

	/**
	 * 修改地址
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "updateAddress", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateAddress(@RequestBody Address address) {
		// 调用修改方法
		MessageUtil message = addressService.updateAddress(address);
		return message;
	}

	/**
	 * 删除地址
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteddress", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteddress(@RequestParam("id") int id) {
		// 调用修改方法
		MessageUtil message = addressService.delete(id);
		return message;
	}

}
