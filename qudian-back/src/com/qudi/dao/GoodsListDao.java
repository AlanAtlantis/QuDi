package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsList;

public interface GoodsListDao {

	/**
	 * 添加商品
	 * 
	 * @param goods
	 * @return
	 */
	int add(GoodsList goods);

	/**
	 * 添加商品与店铺的关系
	 * 
	 * @return
	 */
	int addShop2Goods(@Param("shopId") int shopId, @Param("goodsId") int goodsId);

	/**
	 * 查询用户所有商品列表
	 * 
	 * @param userId
	 * @return
	 */
	List<GoodsList> selectGoodsList(@Param("userId") int userId);

}
