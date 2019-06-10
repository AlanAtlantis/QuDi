package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.Commodity;
import com.qudi.bean.Price;
import com.qudi.bean.Specifications;
import com.qudi.service.CommodityDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/commodity")
public class CommodityController {

	@Autowired
	private CommodityDaoService commodityService;

	/**
	 * 商品查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryCommodity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryCommodity(@RequestParam("id") int id) {
		MessageUtil message = commodityService.queryCommodity(id);
		return message;
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @param comm
	 * @return
	 */
	@RequestMapping(value = "/insertCommodity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertCommodity(HttpServletRequest request, @RequestBody Commodity comm) {
		MessageUtil message = commodityService.insertCommodity(comm, request.getSession());
		return message;
	}

	/**
	 * 修改商品
	 * 
	 * @param comm
	 * @return
	 */
	@RequestMapping(value = "/updateCommdity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateCommdity(@RequestBody Commodity comm) {
		System.out.println("----->>"+comm);
		MessageUtil message = commodityService.updateCommdity(comm);
		return message;
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCommodity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteCommodity(@RequestParam("id") int id) {
		MessageUtil message = commodityService.deleteCommodity(id);
		return message;
	}

	/**
	 * 添加价格
	 * 
	 * @param price
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/insertPrice", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertPrice(@RequestBody Price price,
			@RequestParam("commodityId") int commodityId) {
		MessageUtil message = commodityService.insertQdPrice(price, commodityId);
		return message;
	}

	/**
	 * 添加规格
	 * 
	 * @param specifications
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/insertSpecifications", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertSpecifications(@RequestBody Specifications specifications,
			@RequestParam("commodityId") int commodityId) {
		MessageUtil message = commodityService.insertQdSpecifications(specifications, commodityId);
		return message;
	}

	/**
	 * 修改价格
	 * 
	 * @param price
	 * @return
	 */
	@RequestMapping(value = "/updatePrice", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updatePrice(@RequestBody Price price) {
		MessageUtil message = commodityService.updatePrice(price);
		return message;
	}

	/**
	 * 修改规格
	 * 
	 * @param specifications
	 * @return
	 */
	@RequestMapping(value = "/updateSpecifications", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateSpecifications(@RequestBody Specifications specifications) {
		MessageUtil message = commodityService.updateQdSpecifications(specifications);
		return message;
	}

	/**
	 * 删除价格  Delete commodity prices
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePrice", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deletePrice(@RequestParam("id") int id) {
		MessageUtil message = commodityService.deletePrice(id);
		return message;
	}

	/**
	 * 删除规格   Delete product specifications
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteSpecifications", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteSpecifications(@RequestParam("id") int id) {
		MessageUtil message = commodityService.deleteSpecifications(id);
		return message;
	}

	/**
	 * 查询商品集合   Query commodity set
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/queryUserCommodtiyList", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryUserCommodtiyList(HttpSession session) {
		MessageUtil message = commodityService.queryUserCommodtiyList(session);
		return message;
	}

	/**
	 * 搜索商品  Search for goods
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value = "/queryLikeCommodity", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryLikeCommodity(@RequestParam("keyword") String keyword) {
		MessageUtil message = commodityService.queryLikeCommodity(keyword);
		return message;
	}

}
