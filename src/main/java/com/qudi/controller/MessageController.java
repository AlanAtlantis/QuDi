package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.Message;
import com.qudi.service.MessageDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageDaoService messageService;

	/**
	 * ������Ϣ
	 * 
	 * @param mess
	 * @return
	 */
	@RequestMapping(value = "/insertMessage", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertMessage(@RequestBody Message mess) {
		MessageUtil message = messageService.insertMessage(mess);
		return message;
	}

	/**
	 * ɾ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteMessage(@RequestParam("id") int id) {
		MessageUtil message = messageService.deleteMessage(id);
		return message;
	}

	/**
	 * ��ѯ��Ϣ
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/queryMessage", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryMessage(@RequestParam("userId") int userId) {
		MessageUtil message = messageService.queryMessage(userId);
		return message;
	}

	/**
	 * ��ѯ��ʷ��Ϣ
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/queryHistoryMessage", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryHistoryMessage(@RequestParam("userId") int userId) {
		MessageUtil message = messageService.queryHistoryMessage(userId);
		return message;
	}

}
