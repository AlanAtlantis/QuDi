package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface FootprintDaoService {

	/**
	 * Ìí¼Ó×ã¼£
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertFootprint(int commodityId, int userId);

	/**
	 * É¾³ý×ã¼£
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteFootprint(int id);

	/**
	 * ²é¿´×ã¼£
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectFootprint(int userId);

}
