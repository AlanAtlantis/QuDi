package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.service.FriendDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendDaoService friendService;

	/**
	 * 添加关注
	 * 
	 * @param userId
	 * @param friendId
	 * @return
	 */
	@RequestMapping(value = "/insertFriend", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertFriend(@RequestParam("userId") int userId,
			@RequestParam("friendId") int friendId) {
		MessageUtil message = friendService.insertFriend(userId, friendId);
		return message;
	}

	/**
	 * 删除关注
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteFriend", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteFriend(@RequestParam("id") int id) {
		MessageUtil message = friendService.deleteFriend(id);
		return message;
	}

	/**
	 * 查询关注
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/selectFriend", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectFriend(@RequestParam("userId") int userId) {
		MessageUtil message = friendService.selectFriend(userId);
		return message;
	}

}
