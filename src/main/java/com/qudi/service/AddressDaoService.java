package com.qudi.service;

import org.springframework.stereotype.Service;

import com.qudi.bean.Address;
import com.qudi.util.MessageUtil;

@Service
public interface AddressDaoService {

	/**
	 * 按地址id查询单个地址
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil queryAddress(int id);

	/**
	 * 按用户id查询用户所有地址
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil queryAddressList(int userId);

	/**
	 * 添加地址
	 * 
	 * @param address
	 * @return
	 */
	MessageUtil insertAddress(Address address, int userId);

	/**
	 * 修改地址
	 * 
	 * @param address
	 * @return
	 */
	MessageUtil updateAddress(Address address);

	/**
	 * 删除地址
	 * 
	 * @param addressId
	 * @return
	 */
	MessageUtil delete(int addressId);

}
