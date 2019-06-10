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
	 * �鵥����ַ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryAddress", method = RequestMethod.GET)
	public @RespectBinding MessageUtil queryAddress(@RequestParam("id") int id) {
		// ���ò�ѯ��������id��ѯ
		MessageUtil message = addressService.queryAddress(id);
		return message;
	}

	/**
	 * ��ѯ�����е�ַ
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/queryAddressList", method = RequestMethod.GET)
	public @RespectBinding MessageUtil queryAddressList(@RequestParam("userId") int userId) {
		// �����û�id��ѯ
		MessageUtil message = addressService.queryAddressList(userId);
		return message;
	}

	/**
	 * ��ӵ�ַ
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/insertAddress", method = RequestMethod.GET)
	public @RespectBinding MessageUtil insertAddress(@RequestBody Address address, HttpServletRequest request) {
		// ������ӷ���
		User u = (User) request.getSession().getAttribute("user");
		MessageUtil message = addressService.insertAddress(address, u.getId());
		return message;
	}

	/**
	 * �޸ĵ�ַ
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "updateAddress", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateAddress(@RequestBody Address address) {
		// �����޸ķ���
		MessageUtil message = addressService.updateAddress(address);
		return message;
	}

	/**
	 * ɾ����ַ
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteddress", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteddress(@RequestParam("id") int id) {
		// �����޸ķ���
		MessageUtil message = addressService.delete(id);
		return message;
	}

}
