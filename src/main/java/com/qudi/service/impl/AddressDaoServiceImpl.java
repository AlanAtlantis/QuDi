package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Address;
import com.qudi.dao.AddressDao;
import com.qudi.service.AddressDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("addressService")
public class AddressDaoServiceImpl implements AddressDaoService {

	@Autowired
	private AddressDao addressDao;

	public MessageUtil queryAddress(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ��ѯ������ַ
			Address address = addressDao.queryAddress(id);
			if (address != null) {
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				message.setObject(address);
				return message;
			}
		}
		message.setInfo("�������󣬲�ѯʧ��");
		return message;
	}

	public MessageUtil queryAddressList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// ���û�id��ѯ��ַ����
			List<Address> list = addressDao.queryAddressList(userId);
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

	public MessageUtil insertAddress(Address address, int userId) {
		MessageUtil message = new MessageUtil();
		if (address != null) {
			// ����Ӱ�������ж��Ƿ���ӳɹ�
			int id = addressDao.insertAddress(address);
			System.out.println("id-------------->>>>>>>--------->>>>" + address.getId());
			addressDao.insertUser2Address(userId, address.getId());
			if (id > 0) {
				message.setInfo("��ӳɹ�");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("�����������ʧ��");
		return message;
	}

	public MessageUtil updateAddress(Address address) {
		MessageUtil message = new MessageUtil();
		if (address != null) {
			// ����Ӱ�������ж��Ƿ��޸ĳɹ�
			if (addressDao.updateAddress(address) > 0) {
				message.setInfo("�޸ĳɹ�");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

	public MessageUtil delete(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ����Ӱ�������ж��Ƿ��޸ĳɹ�
			if (addressDao.deleteAddress(id) > 0) {
				// ɾ����ַ���û���ϵ
				addressDao.deleteUser2Address(id);
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("��������ɾ��ʧ��");
		return message;
	}

}
