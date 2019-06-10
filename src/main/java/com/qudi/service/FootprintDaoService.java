package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface FootprintDaoService {

	/**
	 * ����㼣
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertFootprint(int commodityId, int userId);

	/**
	 * ɾ���㼣
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteFootprint(int id);

	/**
	 * �鿴�㼣
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectFootprint(int userId);

}
