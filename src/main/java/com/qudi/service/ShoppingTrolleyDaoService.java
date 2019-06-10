package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface ShoppingTrolleyDaoService {

	/**
	 * ��ӵ����ﳵ
	 * 
	 * @param commodityId
	 * @param userId
	 * @return
	 */
	MessageUtil insertShoppingTrolley(int commodityId, int userId);

	/**
	 * ɾ�����ﳵ��Ʒ
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteShoppingTrolley(int id);

	/**
	 * ��ѯ���ﳵ������Ʒ
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil selectShoppingTrolley(int id);

	/**
	 * ��ѯ���ﳵ����
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectShoppingTrolleyList(int userId);

}
