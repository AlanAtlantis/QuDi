package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Collect;
import com.qudi.dao.CollectDao;
import com.qudi.service.CollectDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("collectService")
public class CollectDaoServiceImpl implements CollectDaoService {

	@Autowired
	private CollectDao collectDao;

	public MessageUtil insertCollect(int commodityId, int userId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0 && userId > 0) {
			// �ж��Ƿ���ӳɹ�
			if (collectDao.insertCollect(commodityId, userId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("��ӳɹ�");
				return message;
			}
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

	public MessageUtil deleteCollect(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// �ж��Ƿ�ɾ���ɹ�
			if (collectDao.deleteCollect(id) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
		}
		message.setInfo("ɾ��ʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectCollect(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��ѯ�û������ղ�
			List<Collect> collectList = collectDao.selectCollect(userId);
			if (collectList.size() > 0) {
				message.setObject(collectList);
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
			message.setInfo("�����ղ�");
			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

}
