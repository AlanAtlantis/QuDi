package com.qudi.service;

import com.qudi.bean.Message;
import com.qudi.util.MessageUtil;

public interface MessageDaoService {

	/**
	 * ������Ϣ
	 * 
	 * @param message
	 * @return
	 */
	MessageUtil insertMessage(Message message);

	/**
	 * ɾ��xinxi
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteMessage(int id);

	/**
	 * ��ѯδ����Ϣ
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryMessage(int userId);

	/**
	 * ��ѯ��ʷ��Ϣ
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryHistoryMessage(int userId);

}
