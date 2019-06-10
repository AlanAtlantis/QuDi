package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.service.ShoppingTrolleyDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/shoppingTrolley")
public class ShoppingTrolleyController {

	@Autowired
	private ShoppingTrolleyDaoService shoppingTrolleyService;

	/**
	 * 添加到购物车
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/insertShoppingTrolley", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryCommodity(@RequestParam("commodityId") int commodityId,
			@RequestParam("userId") int userId) {
		MessageUtil message = shoppingTrolleyService.insertShoppingTrolley(commodityId, userId);
		return message;
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteShoppingTrolley", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteShoppingTrolley(@RequestParam("id") int id) {
		MessageUtil message = shoppingTrolleyService.deleteShoppingTrolley(id);
		return message;
	}

	/**
	 * 查询购物车商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/selectShoppingTrolley", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectShoppingTrolley(@RequestParam("id") int id) {
		MessageUtil message = shoppingTrolleyService.selectShoppingTrolley(id);
		return message;
	}

	/**
	 * 查询用户购物车所有商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/selectShoppingTrolleyList", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectShoppingTrolleyList(@RequestParam("userId") int id) {
		MessageUtil message = shoppingTrolleyService.selectShoppingTrolleyList(id);
		return message;
	}

}
