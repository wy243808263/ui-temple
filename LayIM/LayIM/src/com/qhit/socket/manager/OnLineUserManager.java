package com.qhit.socket.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.qhit.util.cache.LayIMCache;

/**
 * 在线用户管理
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
public class OnLineUserManager {
	static final String cacheName = "LAYIM";
	static final String cacheKey = "ONLINE_USER";

	/**
	 * 添加用户
	 * 
	 * @param userId
	 *            用户编号
	 */
	@SuppressWarnings("unchecked")
	public void addUser(String userId) {
		Map map = LayIMCache.getInstance().get(cacheName, cacheKey);
		if (map == null) {
			map = new ConcurrentHashMap();
		}
		map.put(userId, "online");
		LayIMCache.getInstance().set(cacheName, cacheKey, map);
	}

	/**
	 * 移除用户
	 * 
	 * @param userId
	 *            用户编号
	 */
	public void removeUser(String userId) {
		Map map = LayIMCache.getInstance().get(cacheName, cacheKey);

		if (map == null) {
			return;
		}

		map.remove(userId);
		LayIMCache.getInstance().set(cacheName, cacheKey, map);
	}

	/**
	 * 获取在线用户
	 * 
	 * @return
	 */
	public Map getOnLineUsers() {
		Map map = LayIMCache.getInstance().get(cacheName, cacheKey);
		return map;
	}
}