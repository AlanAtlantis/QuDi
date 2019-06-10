package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Friend;

public interface FriendDao {

	int insertFriend(@Param("userId") int userId, @Param("friendId") int friendId);

	int deleteFriend(@Param("id") int id);

	List<Friend> selectFriend(@Param("userId") int userId);

}
