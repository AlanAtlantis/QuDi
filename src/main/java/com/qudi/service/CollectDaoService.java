package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface CollectDaoService {

	/**
	 * ����ղ�
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertCollect(int commodityId, int userId);

	/**
	 * ɾ���ղ�
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteCollect(int id);

	/**
	 * ��ѯ�ղ�
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectCollect(int userId);

}
