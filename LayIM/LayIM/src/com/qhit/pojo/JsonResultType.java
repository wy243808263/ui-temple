package com.qhit.pojo;

/**
 * JSON返回类型
 * 
 * @author Administrator
 * 
 */
public enum JsonResultType {
	typeSuccess("成功", 0), typeFailed("失败", 1), typeException("异常", 2);

	JsonResultType(String s, int i) {

	}
}
