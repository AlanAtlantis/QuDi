package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Footprint;

public interface FootprintDao {

	int insertFootprint(@Param("commodityId") int commodityId, @Param("userId") int userId);

	int deleteFootprint(@Param("id") int id);

	List<Footprint> selectFootprint(@Param("userId") int userId);

}
