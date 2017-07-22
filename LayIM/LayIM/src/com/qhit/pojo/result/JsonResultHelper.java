package com.qhit.pojo.result;

import com.qhit.pojo.JsonResultType;

/**
 * JSON结果
 * 
 * @author Administrator
 * 
 */
public class JsonResultHelper {
	/**
	 * 创建结果返回
	 * 
	 * @param type
	 *            类型
	 * @param msg
	 *            消息
	 * @param data
	 *            数据
	 * @return
	 */
	public static JsonResult createResult(JsonResultType type, String msg, Object data) {
		JsonResult result = new JsonResult();

		result.setCode(type);
		result.setMsg(msg);
		if (data != null) {
			result.setData(data);
		}
		return result;
	}

	/**
	 * 创建成果消息结果
	 * 
	 * @param msg
	 *            消息
	 * @param data
	 *            数据
	 * @return
	 */
	public static JsonResult createSuccessResult(String msg, Object data) {
		return createResult(JsonResultType.typeSuccess, msg, data);
	}

	/**
	 * 创建成果消息结果
	 * 
	 * @param data
	 *            数据
	 * @return
	 */
	public static JsonResult createSuccessResult(Object data) {
		return createSuccessResult("", data);
	}

	/**
	 * 创建失败的消息结果
	 * 
	 * @param msg
	 *            消息
	 * @return
	 */
	public static JsonResult createFailedResult(String msg) {
		return createResult(JsonResultType.typeFailed, msg, null);
	}
}