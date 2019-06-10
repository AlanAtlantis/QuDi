package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Bargain;
import com.qudi.dao.BargainDao;
import com.qudi.service.BargainDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("bargainService")
public class BargainDaoServiceImpl implements BargainDaoService {

	@Autowired
	private BargainDao bargainDao;

	public MessageUtil insertBargain(Bargain bargain) {
		MessageUtil message = new MessageUtil();
		if (bargain != null) {
			// �ж��Ƿ���ӳɹ�
			if (bargainDao.insertBargain(bargain) > 0) {
				message.setInfo("��ӳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

	public MessageUtil deleteBargain(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// �ж��Ƿ�ɾ���ɹ�
			if (bargainDao.deleteBargain(id) > 0) {
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("ɾ��ʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectBargainUser(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��ѯ�û��������
			List<Bargain> list = bargainDao.selectBargainUser(userId);
			if (list.size() > 0) {
				message.setInfo("��ѯ�ɹ�");
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("�������");

			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectBargainCommodity(int commodityId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0) {
			// ��ѯ��Ʒ�������
			List<Bargain> list = bargainDao.selectBargainCommodity(commodityId);
			if (list.size() > 0) {
				message.setInfo("��ѯ�ɹ�");
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("�������");
			return message;
		}
		message.setInfo("��ѯʧ�ܣ���������");
		return message;
	}

	@Override
	public MessageUtil updateBargain(Bargain bargain) {
		MessageUtil message = new MessageUtil();
		if (bargain != null) {
			// �ж��Ƿ��޸ĳɹ�
			if (bargainDao.updateBargain(bargain) > 0) {
				message.setInfo("�޸ĳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("�޸�ʧ�ܣ��ڲ���������ϵ�ͷ�");
			return message;
		}
		message.setInfo("�޸�ʧ�ܣ���������");
		return message;
	}

}
