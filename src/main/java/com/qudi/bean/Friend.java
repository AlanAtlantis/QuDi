package com.qudi.bean;

public class Friend {

	private int id;
	private int userId;// 用户id
	private int friendId;// 好友id
	private String initializationTime;// 添加时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getInitializationTime() {
		return initializationTime;
	}

	public void setInitializationTime(String initializationTime) {
		this.initializationTime = initializationTime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Friend [id=" + id + ",userId=" + userId + ",friendId=" + friendId + ",initializationTime="
				+ initializationTime + "]";
	}

}
