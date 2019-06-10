package com.qudi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.qudi.bean.OrderForm;
import com.qudi.util.MessageUtil;

public interface OrderFormService {

	/**
	 * 查询单个订单信息
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil queryOrderForm(int id);

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	MessageUtil insertOrderForm(OrderForm order, HttpSession session, int addressId);

	/**
	 * 修改订单
	 * 
	 * @param order
	 * @return
	 */
	MessageUtil updateOrderForm(OrderForm order);

	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteOrderForm(int id);

	/**
	 * 查询用户所有订单
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryOrderFormList(int userId);

	/**
	 * 修改订单地址
	 * 
	 * @param addressId
	 * @param orderId
	 * @return
	 */
	MessageUtil updateOrderAddress(int addressId, int orderId);

}
