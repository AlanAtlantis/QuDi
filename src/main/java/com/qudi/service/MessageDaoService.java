package com.qudi.service;

import com.qudi.bean.Message;
import com.qudi.util.MessageUtil;

public interface MessageDaoService {

	/**
	 * 发送信息
	 * 
	 * @param message
	 * @return
	 */
	MessageUtil insertMessage(Message message);

	/**
	 * 删除xinxi
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteMessage(int id);

	/**
	 * 查询未读信息
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryMessage(int userId);

	/**
	 * 查询历史信息
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryHistoryMessage(int userId);

}
