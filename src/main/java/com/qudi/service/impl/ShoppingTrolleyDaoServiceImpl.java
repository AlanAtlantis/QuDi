package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.ShoppingTrolley;
import com.qudi.dao.ShoppingTrolleyDao;
import com.qudi.service.ShoppingTrolleyDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("shoppingTrolleyService")
public class ShoppingTrolleyDaoServiceImpl implements ShoppingTrolleyDaoService {

	@Autowired
	private ShoppingTrolleyDao shoppingTrolleyDao;

	public MessageUtil insertShoppingTrolley(int commodityId, int userId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0 && userId > 0) {
			// �ж��Ƿ���ӳɹ�
			if (shoppingTrolleyDao.insertShoppingTrolley(commodityId, userId) > 0) {
				message.setInfo("��ӳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("�����������ʧ��");
		return message;
	}

	public MessageUtil deleteShoppingTrolley(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// �ж��Ƿ�ɾ���ɹ�
			if (shoppingTrolleyDao.deleteShoppingTrolley(id) > 0) {
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("��������ɾ��ʧ��");
		return message;
	}

	public MessageUtil selectShoppingTrolley(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ��ѯ���ﳵ��Ʒ
			ShoppingTrolley st = shoppingTrolleyDao.selectShoppingTrolley(id);
			if (st != null) {
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				message.setObject(st);
				return message;
			}
		}
		message.setInfo("�������󣬲�ѯʧ��");
		return message;
	}

	public MessageUtil selectShoppingTrolleyList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��ѯ���ﳵ������Ʒ
			List<ShoppingTrolley> list = shoppingTrolleyDao.selectShoppingTrolleyList(userId);
			if (list.size() > 0) {
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				message.setObject(list);
				return message;
			}
		}
		message.setInfo("�������󣬲�ѯʧ��");
		return message;
	}

}
