package com.qudi.bean;

/**
 * ����ͼƬ
 * 
 * @author AlanAtlantis
 *
 */
public class CommentPicture {

	private int id;// id
	private String picture;// ͼƬ·��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CommentPicture [id=" + id + ",picture=" + picture + "]";
	}

}
