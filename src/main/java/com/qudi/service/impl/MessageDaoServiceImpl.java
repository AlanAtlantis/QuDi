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
			// �����Ϣ
			if (messageDao.insertMessage(message) > 0) {
				messu.setInfo("������Ϣ�ɹ�");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("�����������ʧ��");
		return messu;
	}

	public MessageUtil deleteMessage(int id) {
		MessageUtil messu = new MessageUtil();
		if (id > 0) {
			// ɾ����Ϣ
			if (messageDao.deleteMessage(id) > 0) {
				messu.setInfo("��Ϣɾ���ɹ�");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("��������ɾ��ʧ��");
		return messu;
	}

	public MessageUtil queryMessage(int userId) {
		MessageUtil messu = new MessageUtil();
		if (userId > 0) {
			// ��ѯδ����Ϣ
			List<Message> list = messageDao.queryMessage(userId);
			if (list.size() > 0) {
				messu.setObject(list);
				messu.setInfo("��Ϣ��ѯ�ɹ�");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("�������󣬲�ѯʧ��");
		return messu;
	}

	public MessageUtil queryHistoryMessage(int userId) {
		MessageUtil messu = new MessageUtil();
		if (userId > 0) {
			// ��ѯδ����Ϣ
			List<Message> list = messageDao.queryHistoryMessage(userId);
			if (list.size() > 0) {
				messu.setObject(list);
				messu.setInfo("��Ϣ��ѯ�ɹ�");
				messu.setResult(Result.SUCCEED);
				return messu;
			}
		}
		messu.setInfo("�������󣬲�ѯʧ��");
		return messu;
	}

}
