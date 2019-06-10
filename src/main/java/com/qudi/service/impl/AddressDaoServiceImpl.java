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
			// 查询单个地址
			Address address = addressDao.queryAddress(id);
			if (address != null) {
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				message.setObject(address);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

	public MessageUtil queryAddressList(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 按用户id查询地址集合
			List<Address> list = addressDao.queryAddressList(userId);
			if (list.size() > 0) {
				message.setInfo("查询成功");
				message.setResult(Result.SUCCEED);
				message.setObject(list);
				return message;
			}
		}
		message.setInfo("参数错误，查询失败");
		return message;
	}

	public MessageUtil insertAddress(Address address, int userId) {
		MessageUtil message = new MessageUtil();
		if (address != null) {
			// 根据影响行数判断是否添加成功
			int id = addressDao.insertAddress(address);
			System.out.println("id-------------->>>>>>>--------->>>>" + address.getId());
			addressDao.insertUser2Address(userId, address.getId());
			if (id > 0) {
				message.setInfo("添加成功");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("参数错误，添加失败");
		return message;
	}

	public MessageUtil updateAddress(Address address) {
		MessageUtil message = new MessageUtil();
		if (address != null) {
			// 根据影响行数判断是否修改成功
			if (addressDao.updateAddress(address) > 0) {
				message.setInfo("修改成功");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("参数错误，修改失败");
		return message;
	}

	public MessageUtil delete(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 根据影响行数判断是否修改成功
			if (addressDao.deleteAddress(id) > 0) {
				// 删除地址与用户关系
				addressDao.deleteUser2Address(id);
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
			}
		}
		message.setInfo("参数错误，删除失败");
		return message;
	}

}
