package com.qudi.bean;

/**
 * ÆÀÂÛÍ¼Æ¬
 * 
 * @author AlanAtlantis
 *
 */
public class CommentPicture {

	private int id;// id
	private String picture;// Í¼Æ¬Â·¾¶

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
