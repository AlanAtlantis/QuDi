package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Collect;
import com.qudi.dao.CollectDao;
import com.qudi.service.CollectDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("collectService")
public class CollectDaoServiceImpl implements CollectDaoService {

	@Autowired
	private CollectDao collectDao;

	public MessageUtil insertCollect(int commodityId, int userId) {
		MessageUtil message = new MessageUtil();
		if (commodityId > 0 && userId > 0) {
			// 判断是否添加成功
			if (collectDao.insertCollect(commodityId, userId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("添加成功");
				return message;
			}
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	public MessageUtil deleteCollect(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 判断是否删除成功
			if (collectDao.deleteCollect(id) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("删除成功");
				return message;
			}
		}
		message.setInfo("删除失败，参数错误");
		return message;
	}

	public MessageUtil selectCollect(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 查询用户所有收藏
			List<Collect> collectList = collectDao.selectCollect(userId);
			if (collectList.size() > 0) {
				message.setObject(collectList);
				message.setResult(Result.SUCCEED);
				message.setInfo("删除成功");
				return message;
			}
			message.setInfo("暂无收藏");
			return message;
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

}
