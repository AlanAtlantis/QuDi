package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Collect;

public interface CollectDao {

	int insertCollect(@Param("commodityId") int commodityId, @Param("userId") int userId);

	int deleteCollect(@Param("id") int id);

	List<Collect> selectCollect(@Param("userId") int userId);

}
