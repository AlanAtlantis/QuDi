package com.qudi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.OrderForm;
import com.qudi.bean.Orderdetail;
import com.qudi.bean.User;
import com.qudi.dao.OrderFormDao;
import com.qudi.service.OrderFormService;
import com.qudi.util.MakeOrderNum;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("orderService")
public class OrderFormServiceImpl implements OrderFormService {

	@Autowired
	private OrderFormDao orderDao;

	public MessageUtil queryOrderForm(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 查询订单信息
			OrderForm order = orderDao.queryOrderForm(id);
			// 查询订单明细
			List<Orderdetail> detail = orderDao.queryOrderdetail(id);
			order.setDetail(detail);
			if (order != null) {
				message.setObject(order);
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

	public MessageUtil insertOrderForm(OrderForm order, HttpSession session, int addressId) {
		MessageUtil message = new MessageUtil();
		if (order != null) {
			//生成订单号
			order.setNumber(MakeOrderNum.makeOrderNums());
			// 获取session中的用户对象
			User user = (User) session.getAttribute("user");
			// 添加用户订单
			if (orderDao.insertOrderForm(order) > 0) {
				// 添加订单与用户关系
				orderDao.insertOrderForm2User(user.getId(), order.getId(), addressId);
				// 添加订单明细
				for (Orderdetail detail : order.getDetail()) {
					// 添加订单id
					detail.setOrderId(order.getId());
					// 添加订单明细
					orderDao.insertOrderdetail(detail);
				}
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，添加失败");
		return message;
	}

	public MessageUtil updateOrderForm(OrderForm order) {
		MessageUtil message = new MessageUtil();
		if (order != null) {
			// 修改订单信息
			if (orderDao.updateOrderForm(order) > 0) {
				message.setInfo("修改成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，修改失败");
		return message;
	}

	public MessageUtil deleteOrderForm(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 删除订单信息
			if (orderDao.deleteOrderForm(id) > 0) {
				// 删除订单与用户关系
				orderDao.deleteOrderForm2User(id);
				// 删除订单明细
				orderDao.deleteOrderdetail(id);
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，删除失败");
		return message;
	}

	public MessageUtil queryOrderFormList(int userId) {
		MessageUtil message = new MessageUtil();
		// 根据用户id查询所有订单id
		List<Integer> idList = orderDao.queryIdList(userId);
		if (idList.size() > 0) {
			List<OrderForm> list = orderDao.queryOrderFormList(idList);
			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

	public MessageUtil updateOrderAddress(int addressId, int orderId) {
		MessageUtil message = new MessageUtil();
		if (addressId > 0) {
			if (orderId > 0) {
				// 修改订单地址
				if (orderDao.updateOrderAddress(addressId, orderId) > 0) {
					message.setInfo("修改成功");
					message.setResult(Result.SUCCEED);
					return message;
				}
			}
		}
		message.setInfo("参数错误，修改失败");
		return message;
	}

}
