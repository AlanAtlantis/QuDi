package com.qudi.bean;

public class Friend {

	private int id;
	private int userId;// �û�id
	private int friendId;// ����id
	private String initializationTime;// ���ʱ��

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
