package com.qhit.pojo.result;

import com.qhit.pojo.JsonResultType;

/**
 * Json工具类
 * 
 * @author Administrator
 * 
 */
public class JsonResult {

	private int code;
	private String msg;
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(JsonResultType code) {
		// 枚举转换为int类型
		this.code = code.ordinal();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}