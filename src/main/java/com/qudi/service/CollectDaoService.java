package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface CollectDaoService {

	/**
	 * 添加收藏
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertCollect(int commodityId, int userId);

	/**
	 * 删除收藏
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteCollect(int id);

	/**
	 * 查询收藏
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectCollect(int userId);

}
