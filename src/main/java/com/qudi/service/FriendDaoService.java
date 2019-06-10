package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface FriendDaoService {

	MessageUtil insertFriend(int userId, int friendId);

	MessageUtil deleteFriend(int id);

	MessageUtil selectFriend(int userId);

}
