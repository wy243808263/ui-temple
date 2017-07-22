package com.qhit.util.serializer;

import java.util.List;

/**
 * JSON序列化
 * 
 * @author Administrator
 * 
 */
public interface IJsonSerializer {
	/**
	 * 序列化某个对象
	 * 
	 * @param t
	 *            泛型
	 * @return
	 */
	<T> String toJSON(T t);

	/**
	 * 反序列化
	 * 
	 * @param json
	 *            字符串
	 * @param clazz
	 *            类型
	 * @return
	 */
	<T> T toObject(String json, Class<T> clazz);

	/**
	 * 序列化成数组
	 * 
	 * @param json
	 *            字符串
	 * @param clazz
	 *            类型
	 * @return
	 */
	<T> List<T> toArray(String json, Class<T> clazz);
}