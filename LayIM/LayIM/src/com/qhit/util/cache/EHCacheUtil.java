package com.qhit.util.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * 缓存工具类
 * 
 * @author Administrator
 * 
 */
public class EHCacheUtil {

	/**
	 * 
	 * @param kClass
	 * @param vClass
	 * @param configureName
	 * @return
	 */
	public <K, V> CacheManager getCacheManager(Class<K> kClass, Class<V> vClass, String configureName) {
		CacheManager manager = CacheManagerBuilder.newCacheManagerBuilder()
				.withCache(configureName, CacheConfigurationBuilder.newCacheConfigurationBuilder(kClass, vClass, ResourcePoolsBuilder.heap(10))).build();
		manager.init();
		return manager;
	}

	/**
	 * 
	 * 获取缓存
	 * 
	 * @param kClass
	 * @param vClass
	 * @param cacheName
	 *            缓存名称
	 * @param configureName
	 *            配置名称
	 * @param manager
	 *            管理
	 * 
	 * @return
	 */
	public <K, V> Cache<K, V> getCache(Class<K> kClass, Class<V> vClass, String cacheName, String configureName, CacheManager manager) {

		Cache<K, V> cache = manager.getCache(configureName, kClass, vClass);
		/*
		 * Cache<K, V> cache = manager.createCache(cacheName, CacheConfigurationBuilder.newCacheConfigurationBuilder(kClass, vClass, ResourcePoolsBuilder.heap(10)).build());
		 */
		return cache;
	}

	/**
	 * 关闭消息管理
	 * 
	 * @param manager
	 *            管理
	 * @param configureName
	 *            配置名称
	 */
	public void closeCache(CacheManager manager, String configureName) {
		manager.removeCache(configureName);
		manager.close();
	}
}