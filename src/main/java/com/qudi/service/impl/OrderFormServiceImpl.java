package com.qudi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.OrderForm;
import com.qudi.bean.Orderdetail;
import com.qudi.bean.User;
import com.qudi.dao.OrderFormDao;
import com.qudi.service.OrderFormService;
import com.qudi.util.MakeOrderNum;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("orderService")
public class OrderFormServiceImpl implements OrderFormService {

	@Autowired
	private OrderFormDao orderDao;

	public MessageUtil queryOrderForm(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ��ѯ������Ϣ
			OrderForm order = orderDao.queryOrderForm(id);
			// ��ѯ������ϸ
			List<Orderdetail> detail = orderDao.queryOrderdetail(id);
			order.setDetail(detail);
			if (order != null) {
				message.setObject(order);
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("�������󣬲�ѯʧ��");
		return message;
	}

	public MessageUtil insertOrderForm(OrderForm order, HttpSession session, int addressId) {
		MessageUtil message = new MessageUtil();
		if (order != null) {
			//���ɶ�����
			order.setNumber(MakeOrderNum.makeOrderNums());
			// ��ȡsession�е��û�����
			User user = (User) session.getAttribute("user");
			// ����û�����
			if (orderDao.insertOrderForm(order) > 0) {
				// ��Ӷ������û���ϵ
				orderDao.insertOrderForm2User(user.getId(), order.getId(), addressId);
				// ��Ӷ�����ϸ
				for (Orderdetail detail : order.getDetail()) {
					// ��Ӷ���id
					detail.setOrderId(order.getId());
					// ��Ӷ�����ϸ
					orderDao.insertOrderdetail(detail);
				}
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("�����������ʧ��");
		return message;
	}

	public MessageUtil updateOrderForm(OrderForm order) {
		MessageUtil message = new MessageUtil();
		if (order != null) {
			// �޸Ķ�����Ϣ
			if (orderDao.updateOrderForm(order) > 0) {
				message.setInfo("�޸ĳɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

	public MessageUtil deleteOrderForm(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// ɾ��������Ϣ
			if (orderDao.deleteOrderForm(id) > 0) {
				// ɾ���������û���ϵ
				orderDao.deleteOrderForm2User(id);
				// ɾ��������ϸ
				orderDao.deleteOrderdetail(id);
				message.setInfo("ɾ���ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("��������ɾ��ʧ��");
		return message;
	}

	public MessageUtil queryOrderFormList(int userId) {
		MessageUtil message = new MessageUtil();
		// �����û�id��ѯ���ж���id
		List<Integer> idList = orderDao.queryIdList(userId);
		if (idList.size() > 0) {
			List<OrderForm> list = orderDao.queryOrderFormList(idList);
			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("��ѯ�ɹ�");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("�������󣬲�ѯʧ��");
		return message;
	}

	public MessageUtil updateOrderAddress(int addressId, int orderId) {
		MessageUtil message = new MessageUtil();
		if (addressId > 0) {
			if (orderId > 0) {
				// �޸Ķ�����ַ
				if (orderDao.updateOrderAddress(addressId, orderId) > 0) {
					message.setInfo("�޸ĳɹ�");
					message.setResult(Result.SUCCEED);
					return message;
				}
			}
		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

}
