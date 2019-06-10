package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Commodity;
import com.qudi.bean.Price;
import com.qudi.bean.Specifications;

public interface CommodityDao {

	Commodity queryCommodity(@Param("id") int id);

	List<Integer> queryCommodity2Price(@Param("id") int id);

	List<Price> queryPrice(@Param("idList") List<Integer> idList);

	List<Specifications> querySpecificationsList(@Param("idList") List<Integer> idList);

	List<Integer> querySpecificationsIdList(@Param("id") int id);

	int insertCommodity(Commodity comm);

	int updateCommdity(Commodity comm);

	int deleteCommodity(@Param("id") int comm);

	int insertQdUser2Commodity(@Param("userId") int userId, @Param("commodityId") int commodityId);

	int insertQdPrice(Price price);

	int insertQdSpecifications(Specifications specifications);

	int deleteQdUser2Commodity(@Param("commodityId") int commodityId);

	int insertQdCommodity2Price(@Param("commodityId") int commodityId, @Param("priceId") int priceId);

	int insertQdCommodity2Specifications(@Param("commodityId") int commodityId,
			@Param("specificationsId") int specificationsId);

	int updatePrice(Price price);

	int updateQdSpecifications(Specifications specifications);

	int deleteQdPrice(@Param("idList") List<Integer> idList);

	int deleteQdCommodity2Price(@Param("commodityId") int commodityId, @Param("priceId") int priceId);

	int deleteQdSpecifications(@Param("idList") List<Integer> idList);

	int deleteQdCommodity2Specifications(@Param("commodityId") int commodityId,
			@Param("specificationsId") int specificationsId);

	List<Commodity> queryUserCommodtiyList(@Param("idList") List<Integer> idList);

	List<Integer> querUserCommodityId(@Param("userId") int userId);

	List<Commodity> queryLikeCommodity(@Param("keyword") String keyword);

}
