package com.qudi.bean;

/**
 * 消息bean
 * 
 * @author AlanAtlantis
 *
 */
public class Message {

	private int id;// id
	private String content;// 内容
	private int status;// 状态
	private int addresseeId;// 收信人
	private int senderId;// 发送方
	private String timeDeparture;// 发送时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAddresseeId() {
		return addresseeId;
	}

	public void setAddresseeId(int addresseeId) {
		this.addresseeId = addresseeId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Message [id=" + id + ",content=" + content + ",status=" + status + ",addresseeId=" + addresseeId
				+ ",senderId=" + senderId + ",timeDeparture=" + timeDeparture + "]";
	}

}
