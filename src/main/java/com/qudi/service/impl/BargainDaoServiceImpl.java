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
			// 判断是否添加成功
			if (bargainDao.insertBargain(bargain) > 0) {
				message.setInfo("添加成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	public MessageUtil deleteBargain(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 判断是否删除成功
			if (bargainDao.deleteBargain(id) > 0) {
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("删除失败，参数错误");
		return message;
	}

	public MessageUtil selectBargainUser(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 查询用户所有议价
			List<Bargain> list = bargainDao.selectBargainUser(userId);
			if (list.size() > 0) {
				message.setInfo("查询成功");
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("暂无议价");

			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	public MessageUtil selectBargainCommodity(int commodityId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0) {
			// 查询商品所有议价
			List<Bargain> list = bargainDao.selectBargainCommodity(commodityId);
			if (list.size() > 0) {
				message.setInfo("查询成功");
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("暂无议价");
			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

	@Override
	public MessageUtil updateBargain(Bargain bargain) {
		MessageUtil message = new MessageUtil();
		if (bargain != null) {
			// 判断是否修改成功
			if (bargainDao.updateBargain(bargain) > 0) {
				message.setInfo("修改成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("修改失败，内部错误，请联系客服");
			return message;
		}
		message.setInfo("修改失败，参数错误");
		return message;
	}

}
