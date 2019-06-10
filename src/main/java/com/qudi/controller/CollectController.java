package com.qudi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.User;
import com.qudi.service.CollectDaoService;
import com.qudi.service.FootprintDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	private CollectDaoService collectService;

	/**
	 * 添加收藏
	 * 
	 * @param commodityId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/insertCollect", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertCollect(@RequestParam("commodityId") int commodityId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		MessageUtil message = collectService.insertCollect(commodityId, user.getId());
		return message;
	}

	/**
	 * 删除收藏
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCollect", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteCollect(@RequestParam("id") int id) {

		MessageUtil message = collectService.deleteCollect(id);
		return message;
	}

	/**
	 * 查询收藏
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectCollect", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectCollect(HttpSession session) {
		User user = (User) session.getAttribute("user");
		MessageUtil message = collectService.selectCollect(user.getId());
		return message;
	}

}
