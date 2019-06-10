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
			// 判断是否添加成功
			if (footprintDao.insertFootprint(commodityId, userId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("添加成功");
				return message;
			}
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	public MessageUtil deleteFootprint(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 判断是否删除成功
			if (footprintDao.deleteFootprint(id) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("删除成功");
				return message;
			}
		}
		message.setInfo("删除失败，参数错误");
		return message;
	}

	public MessageUtil selectFootprint(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 查询用户所有足迹
			List<Footprint> footprint = footprintDao.selectFootprint(userId);
			if (footprint.size() > 0) {
				message.setObject(footprint);
				message.setResult(Result.SUCCEED);
				message.setInfo("删除成功");
				return message;
			}
			message.setInfo("暂无足迹");
			return message;
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

}
