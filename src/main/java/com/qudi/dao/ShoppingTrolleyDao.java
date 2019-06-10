package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.ShoppingTrolley;

public interface ShoppingTrolleyDao {

	int insertShoppingTrolley(@Param("commodityId") int commodityId, @Param("userId") int userId);

	int deleteShoppingTrolley(@Param("id") int id);

	ShoppingTrolley selectShoppingTrolley(@Param("id") int id);

	List<ShoppingTrolley> selectShoppingTrolleyList(@Param("userId") int userId);

}
