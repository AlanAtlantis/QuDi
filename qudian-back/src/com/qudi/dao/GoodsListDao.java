package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsList;

public interface GoodsListDao {

	/**
	 * �����Ʒ
	 * 
	 * @param goods
	 * @return
	 */
	int add(GoodsList goods);

	/**
	 * �����Ʒ����̵Ĺ�ϵ
	 * 
	 * @return
	 */
	int addShop2Goods(@Param("shopId") int shopId, @Param("goodsId") int goodsId);

	/**
	 * ��ѯ�û�������Ʒ�б�
	 * 
	 * @param userId
	 * @return
	 */
	List<GoodsList> selectGoodsList(@Param("userId") int userId);

}
