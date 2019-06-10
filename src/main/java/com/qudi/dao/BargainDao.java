package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Bargain;

public interface BargainDao {

	int insertBargain(Bargain bargain);

	int deleteBargain(@Param("id") int id);

	List<Bargain> selectBargainUser(@Param("userId") int userId);

	List<Bargain> selectBargainCommodity(@Param("commodityId") int commodityId);

	int updateBargain(Bargain bargain);
}
