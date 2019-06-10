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

import com.qudi.bean.OrderForm;
import com.qudi.service.OrderFormService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/order")
public class OrderFromController {

	@Autowired
	private OrderFormService orderService;

	/**
	 * 查询单个订单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryOrderForm", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryOrderForm(@RequestParam int id) {
		MessageUtil me = orderService.queryOrderForm(id);
		return me;
	}

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @param session
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value = "/insertOrderForm", method = RequestMethod.GET)
	public @ResponseBody MessageUtil insertOrderForm(@RequestBody OrderForm order, HttpSession session,
			@RequestParam("addressId") int addressId) {
		MessageUtil me = orderService.insertOrderForm(order, session, addressId);
		return me;
	}

	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/updateOrderForm", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateOrderForm(@RequestBody OrderForm order) {
		MessageUtil me = orderService.updateOrderForm(order);
		return me;
	}

	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteOrderForm", method = RequestMethod.GET)
	public @ResponseBody MessageUtil deleteOrderForm(@RequestParam("id") int id) {
		MessageUtil me = orderService.deleteOrderForm(id);
		return me;
	}

	/**
	 * 根据用户id查询所有订单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryOrderFormList", method = RequestMethod.GET)
	public @ResponseBody MessageUtil queryOrderFormList(@RequestParam("userId") int id) {
		MessageUtil me = orderService.queryOrderFormList(id);
		return me;
	}

	/**
	 * 修改订单地址
	 * 
	 * @param addressId
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/updateOrderAddress", method = RequestMethod.GET)
	public @ResponseBody MessageUtil updateOrderAddress(@RequestParam("addressId") int addressId,
			@RequestParam("orderId") int orderId) {
		MessageUtil me = orderService.updateOrderAddress(addressId, orderId);
		return me;
	}

}
