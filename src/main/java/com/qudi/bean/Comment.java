package com.qudi.bean;

import java.util.List;

/**
 * ����
 * 
 * @author AlanAtlantis
 *
 */
public class Comment {

	private int id;// id
	private String content;// ����
	private int giveLike;// ������
	private String initializationTime;// ����ʱ��
	private List<CommentPicture> pricture;// ����ͼƬ��ַ

	public int getId() {
		return id;
	}

	public List<CommentPicture> getPricture() {
		return pricture;
	}

	public void setPricture(List<CommentPicture> pricture) {
		this.pricture = pricture;
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

	public int getGiveLike() {
		return giveLike;
	}

	public void setGiveLike(int giveLike) {
		this.giveLike = giveLike;
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
		return "Comment [id=" + id + ",content=" + content + ",giveLike=" + giveLike + ",initializationTime="
				+ initializationTime + ",pricture=" + pricture + "]";
	}

}
