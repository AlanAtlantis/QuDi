package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Friend;
import com.qudi.dao.FriendDao;
import com.qudi.service.FriendDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("friendService")
public class FriendDaoServiceImpl implements FriendDaoService {

	@Autowired
	private FriendDao friendDao;

	public MessageUtil insertFriend(int userId, int friendId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0 && friendId > 0) {
			// 添加判断
			if (friendDao.insertFriend(userId, friendId) > 0) {
				message.setInfo("添加成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	public MessageUtil deleteFriend(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			// 删除判断
			if (friendDao.deleteFriend(id) > 0) {
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("删除失败，参数错误");
		return message;
	}

	public MessageUtil selectFriend(int userId) {
		MessageUtil message = new MessageUtil();
		if (userId > 0) {
			// 查询方法调用
			List<Friend> list = friendDao.selectFriend(userId);
			// 判断是否查询成功
			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("暂无数据");
		}
		message.setInfo("查询失败，参数错误");
		return message;
	}

}
