package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface ShoppingTrolleyDaoService {

	/**
	 * 添加到购物车
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertShoppingTrolley(int commodityId, int userId);

	/**
	 * 删除购物车商品
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteShoppingTrolley(int id);

	/**
	 * 查询购物车单个商品
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil selectShoppingTrolley(int id);

	/**
	 * 查询购物车集合
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectShoppingTrolleyList(int userId);

}
