package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Collect;
import com.qudi.bean.Footprint;
import com.qudi.dao.FootprintDao;
import com.qudi.service.FootprintDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("footprintService")
public class FootprintDaoServiceImpl implements FootprintDaoService {

	@Autowired
	private FootprintDao footprintDao;

	public MessageUtil insertFootprint(int commodityId, int userId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0 && userId > 0) {
			// �ж��Ƿ���ӳɹ�
			if (footprintDao.insertFootprint(commodityId, userId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("��ӳɹ�");
				return message;
			}
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

	public MessageUtil deleteFootprint(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// �ж��Ƿ�ɾ���ɹ�
			if (footprintDao.deleteFootprint(id) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
		}
		message.setInfo("ɾ��ʧ�ܣ���������");
		return message;
	}

	public MessageUtil selectFootprint(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ��ѯ�û������㼣
			List<Footprint> footprint = footprintDao.selectFootprint(userId);
			if (footprint.size() > 0) {
				message.setObject(footprint);
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
			message.setInfo("�����㼣");
			return message;
		}
		message.setInfo("���ʧ�ܣ���������");
		return message;
	}

}
