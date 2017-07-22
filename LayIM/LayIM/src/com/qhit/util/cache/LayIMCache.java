package com.qhit.util.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.ehcache.Cache;
import org.ehcache.CacheManager;

/**
 * 缓存工具类
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
public class LayIMCache {

	private static LayIMCache _instance;

	// 加锁
	static final Lock instanceLock = new ReentrantLock();
	// 存储manager实例
	public static Map<String, CacheManager> CacheManagerContext = new ConcurrentHashMap<>();

	final String HASHMAP_CONFIGURE = "HASHMAP_CONFIGURE";
	final String LIST_CONFIGURE = "LIST_CONFIGURE";

	private EHCacheUtil cacheUtil = new EHCacheUtil();

	private LayIMCache() {
	}

	/**
	 * 获取类的实例
	 * 
	 * @return
	 */
	public static LayIMCache getInstance() {
		if (_instance == null) {
			instanceLock.lock();
			if (_instance == null) {
				_instance = new LayIMCache();
			}
			instanceLock.unlock();
		}
		return _instance;
	}

	/**
	 * 获取管理
	 * 
	 * @param kClass
	 * @param vClass
	 * @param key
	 *            键
	 * 
	 * @return
	 */
	private <K, V> CacheManager getManager(Class<K> kClass, Class<V> vClass, String key) {
		if (CacheManagerContext.containsKey(key)) {
			return CacheManagerContext.get(key);
		}
		CacheManager manager = cacheUtil.getCacheManager(kClass, vClass, key);
		CacheManagerContext.put(key, manager);

		return manager;
	}

	/**
	 * 获取Hash管理
	 * 
	 * @return
	 */
	private CacheManager getHashMapManager() {
		return getManager(String.class, Map.class, HASHMAP_CONFIGURE);
	}

	/**
	 * 获取List管理
	 * 
	 * @return
	 */
	private CacheManager getListManager() {
		return getManager(String.class, List.class, LIST_CONFIGURE);
	}

	/**
	 * 获取集合缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @return
	 */
	private Cache<String, List> getListCache(String cacheName) {
		CacheManager manager = getListManager();
		return cacheUtil.getCache(String.class, List.class, cacheName, LIST_CONFIGURE, manager);
	}

	/**
	 * 获取Hash缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @return
	 */
	private Cache<String, Map> getHashMapCache(String cacheName) {
		CacheManager manager = getHashMapManager();
		return cacheUtil.getCache(String.class, Map.class, cacheName, HASHMAP_CONFIGURE, manager);
	}

	/**
	 * 放入缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * 
	 */
	public void set(String cacheName, String key, Map value) {
		Cache<String, Map> cache = getHashMapCache(cacheName);
		cache.put(key, value);
	}

	/**
	 * 获取缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param key
	 *            键
	 * @return Map
	 */
	public Map get(String cacheName, String key) {
		Cache<String, Map> cache = getHashMapCache(cacheName);
		Map map = cache.get(key);
		return map;
	}

	/**
	 * 设置缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void setListCache(String cacheName, String key, List value) {
		Cache<String, List> cache = getListCache(cacheName);
		cache.put(key, value);
	}

	/**
	 * 获取缓存
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param key
	 *            键
	 * @return List 返回集合
	 */
	public List getListCache(String cacheName, String key) {
		Cache<String, List> cache = getListCache(cacheName);
		List list = cache.get(key);
		return list;
	}
}