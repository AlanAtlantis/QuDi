package com.qudi.service;

import com.qudi.bean.Bargain;
import com.qudi.util.MessageUtil;

public interface BargainDaoService {
	/**
	 * ������
	 * 
	 * @param bargain
	 * @return
	 */
	MessageUtil insertBargain(Bargain bargain);

	/**
	 * ɾ�����
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteBargain(int id);

	/**
	 * �û� ��ѯ���
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectBargainUser(int userId);

	/**
	 * �鿴��Ʒ�������
	 * 
	 * @param commodityId
	 * @return
	 */
	MessageUtil selectBargainCommodity(int commodityId);

	/**
	 * �޸����
	 * 
	 * @param bargain
	 * @return
	 */
	MessageUtil updateBargain(Bargain bargain);
}
