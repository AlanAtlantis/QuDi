package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Message;
import com.qudi.dao.MessageDao;
import com.qudi.service.MessageDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("messageService")
public class MessageDaoServiceImpl implements MessageDaoService {

	@Autowired
	private MessageDao messageDao;

	public MessageUtil insertMessage(Message message) {
		MessageUtil messu = new MessageUtil();
		if (message != null) {
			// 添加信息
			if (messageDao.insertMessage(message) > 0) {
				messu.setInfo("发送信息成功");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("参数错误，添加失败");
		return messu;
	}

	public MessageUtil deleteMessage(int id) {
		MessageUtil messu = new MessageUtil();
		if (id > 0) {
			// 删除信息
			if (messageDao.deleteMessage(id) > 0) {
				messu.setInfo("信息删除成功");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("参数错误，删除失败");
		return messu;
	}

	public MessageUtil queryMessage(int userId) {
		MessageUtil messu = new MessageUtil();
		if (userId > 0) {
			// 查询未读信息
			List<Message> list = messageDao.queryMessage(userId);
			if (list.size() > 0) {
				messu.setObject(list);
				messu.setInfo("信息查询成功");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("参数错误，查询失败");
		return messu;
	}

	public MessageUtil queryHistoryMessage(int userId) {
		MessageUtil messu = new MessageUtil();
		if (userId > 0) {
			// 查询未读信息
			List<Message> list = messageDao.queryHistoryMessage(userId);
			if (list.size() > 0) {
				messu.setObject(list);
				messu.setInfo("信息查询成功");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("参数错误，查询失败");
		return messu;
	}

}
