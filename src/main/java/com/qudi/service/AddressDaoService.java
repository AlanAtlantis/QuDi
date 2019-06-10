package com.qudi.service;

import org.springframework.stereotype.Service;

import com.qudi.bean.Address;
import com.qudi.util.MessageUtil;

@Service
public interface AddressDaoService {

	/**
	 * ����ַid��ѯ������ַ
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil queryAddress(int id);

	/**
	 * ���û�id��ѯ�û����е�ַ
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryAddressList(int userId);

	/**
	 * ��ӵ�ַ
	 * 
	 * @param address
	 * @return
	 */
	MessageUtil insertAddress(Address address, int userId);

	/**
	 * �޸ĵ�ַ
	 * 
	 * @param address
	 * @return
	 */
	MessageUtil updateAddress(Address address);

	/**
	 * ɾ����ַ
	 * 
	 * @param addressId
	 * @return
	 */
	MessageUtil delete(int addressId);

}
