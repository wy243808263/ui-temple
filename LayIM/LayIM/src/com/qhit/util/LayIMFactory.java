package com.qhit.util;

import com.qhit.socket.manager.IUserManager;
import com.qhit.socket.manager.UserManager;
import com.qhit.util.serializer.FastJsonSerializer;
import com.qhit.util.serializer.IJsonSerializer;

/**
 * 工厂工具类
 * 
 * @author Administrator
 * 
 */
public class LayIMFactory {
	/**
	 * 创建序列化器
	 * 
	 * @return
	 */
	public static IJsonSerializer createSerializer() {
		return new FastJsonSerializer();
	}

	/**
	 * 创建在线人员管理工具
	 * 
	 * @return
	 */
	public static IUserManager createManager() {
		return UserManager.getInstance();
	}
}