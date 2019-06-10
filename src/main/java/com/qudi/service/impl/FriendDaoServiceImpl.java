package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Friend;
import com.qudi.dao.FriendDao;
import com.qudi.service.FriendDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("friendService")
public class FriendDaoServiceImpl implements FriendDaoService {

	@Autowired
	private FriendDao friendDao;

	public MessageUtil insertFriend(int userId, int friendId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0 && friendId > 0) {
			// ����ж�
			if (friendDao.insertFriend(userId, friendId) > 0) {
				message.setInfo("��ӳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

	public MessageUtil deleteFriend(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ɾ���ж�
			if (friendDao.deleteFriend(id) > 0) {
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("ɾ��ʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectFriend(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��ѯ��������
			List<Friend> list = friendDao.selectFriend(userId);
			// �ж��Ƿ��ѯ�ɹ�
			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("��������");
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

}
