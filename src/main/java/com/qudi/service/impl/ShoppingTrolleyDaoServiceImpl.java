package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.ShoppingTrolley;
import com.qudi.dao.ShoppingTrolleyDao;
import com.qudi.service.ShoppingTrolleyDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("shoppingTrolleyService")
public class ShoppingTrolleyDaoServiceImpl implements ShoppingTrolleyDaoService {

	@Autowired
	private ShoppingTrolleyDao shoppingTrolleyDao;

	public MessageUtil insertShoppingTrolley(int commodityId, int userId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0 && userId > 0) {
			// 判断是否添加成功
			if (shoppingTrolleyDao.insertShoppingTrolley(commodityId, userId) > 0) {
				message.setInfo("添加成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，添加失败");
		return message;
	}

	public MessageUtil deleteShoppingTrolley(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 判断是否删除成功
			if (shoppingTrolleyDao.deleteShoppingTrolley(id) > 0) {
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("参数错误，删除失败");
		return message;
	}

	public MessageUtil selectShoppingTrolley(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 查询购物车商品
			ShoppingTrolley st = shoppingTrolleyDao.selectShoppingTrolley(id);
			if (st != null) {
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				message.setObject(st);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

	public MessageUtil selectShoppingTrolleyList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 查询购物车所有商品
			List<ShoppingTrolley> list = shoppingTrolleyDao.selectShoppingTrolleyList(userId);
			if (list.size() > 0) {
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				message.setObject(list);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

}
