package com.qudi.bean;

/**
 * »Ø¸´
 * 
 * @author AlanAtlantis
 *
 */
public class Reply {

	private int id;
	private String conetnt;
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConetnt() {
		return conetnt;
	}

	public void setConetnt(String conetnt) {
		this.conetnt = conetnt;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ",conetnt=" + conetnt + ",time=" + time + "]";
	}
}
