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
import com.qudi.service.FootprintDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/footprint")
public class FootprintController {
	@Autowired
	private FootprintDaoService footprintService;

	/**
	 * Ìí¼Ó×ã¼£
	 * 
	 * @param commodityId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/insertFootprint", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertFootprint(@RequestParam("commodityId") int commodityId,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		MessageUtil message = footprintService.insertFootprint(commodityId, user.getId());
		return message;
	}

	/**
	 * É¾³ý×ã¼£
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteFootprint", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteFootprint(@RequestParam("id") int id) {

		MessageUtil message = footprintService.deleteFootprint(id);
		return message;
	}

	/**
	 * ²éÑ¯×ã¼£
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectFootprint", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectFootprint(HttpSession session) {
		User user = (User) session.getAttribute("user");
		MessageUtil message = footprintService.selectFootprint(user.getId());
		return message;
	}

}
