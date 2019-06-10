package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.Bargain;
import com.qudi.bean.Comment;
import com.qudi.service.BargainDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/bargain")
public class BargainController {
	
	@Autowired
	private BargainDaoService bargainService;

	/**
	 * ������
	 * 
	 * @param bargain
	 * @return
	 */
	@RequestMapping(value = "/insertBargain", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertBargain(@RequestBody Bargain bargain) {
		MessageUtil message = bargainService.insertBargain(bargain);
		return message;
	}

	/**
	 * ɾ�����
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteBargain", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteBargain(@RequestParam("id") int id) {
		
		MessageUtil message = bargainService.deleteBargain(id);
		return message;
	}

	/**
	 * �û���ѯ���
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/selectBargainUser", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectBargainUser(@RequestParam("userId") int userId) {
		
		MessageUtil message = bargainService.selectBargainUser(userId);
		return message;
	}

	/**
	 * ��ѯ��Ʒ���������
	 * 
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/selectBargainCommodity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectBargainCommodity(@RequestParam("commodityId") int commodityId) {
		MessageUtil message = bargainService.selectBargainCommodity(commodityId);
		return message;
	}

	/**
	 * �޸����
	 * 
	 * @param bargain
	 * @return
	 */
	@RequestMapping(value = "/updateBargain", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateBargain(@RequestBody Bargain bargain) {
		MessageUtil message = bargainService.updateBargain(bargain);
		return message;
	}

}
