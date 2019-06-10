package com.qudi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.qudi.bean.OrderForm;
import com.qudi.util.MessageUtil;

public interface OrderFormService {

	/**
	 * ��ѯ����������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil queryOrderForm(int id);

	/**
	 * ��Ӷ���
	 * 
	 * @param order
	 * @return
	 */
	MessageUtil insertOrderForm(OrderForm order, HttpSession session, int addressId);

	/**
	 * �޸Ķ���
	 * 
	 * @param order
	 * @return
	 */
	MessageUtil updateOrderForm(OrderForm order);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteOrderForm(int id);

	/**
	 * ��ѯ�û����ж���
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryOrderFormList(int userId);

	/**
	 * �޸Ķ�����ַ
	 * 
	 * @param addressId
	 * @param orderId
	 * @return
	 */
	MessageUtil updateOrderAddress(int addressId, int orderId);

}
