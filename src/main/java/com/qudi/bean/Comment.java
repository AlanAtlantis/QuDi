package com.qudi.bean;

import java.util.List;

/**
 * 评论
 * 
 * @author AlanAtlantis
 *
 */
public class Comment {

	private int id;// id
	private String content;// 内容
	private int giveLike;// 点赞数
	private String initializationTime;// 评论时间
	private List<CommentPicture> pricture;// 评论图片地址

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
