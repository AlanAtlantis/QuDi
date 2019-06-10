package com.qudi.util;

/**
 * 返回信息帮助类
 * 
 * @author AlanAtlantis
 *
 */
public class MessageUtil {

	private Object object;

	private String info;

	private Result result=Result.FAILED;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MessageUtil [object=" + object + ",info=" + info + ",result=" + result + "]";
	}
}
