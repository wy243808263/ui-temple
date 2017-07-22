package com.qhit.socket.manager;

import java.util.List;

import com.qhit.dao.LayIMDao;
import com.qhit.util.cache.LayIMCache;

/**
 * 用户组实体类
 * 
 * @author Administrator
 * 
 */
public class GroupUserManager {
	private static final String cacheName = "LAYIM_GROUP";
	private static final String cacheKey = "GM_";

	/**
	 * 每个组存一个
	 * 
	 * @param groupId
	 *            组编号
	 * @return
	 */
	private String getCacheKey(int groupId) {
		return cacheKey + groupId;
	}

	/**
	 * 将某个组的用户id存入缓存 key=》list
	 * 
	 * @param groupId
	 *            组编号
	 * @param userIds
	 *            用户编号
	 * @return
	 */
	public boolean saveGroupMemeberIds(int groupId, List<String> userIds) {
		String key = getCacheKey(groupId);
		LayIMCache.getInstance().setListCache(cacheName, key, userIds);
		return true;
	}

	/**
	 * 获取组成员
	 * 
	 * @param groupId
	 *            组编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getGroupMembers(int groupId) {
		String key = getCacheKey(groupId);
		List<String> list = LayIMCache.getInstance().getListCache(cacheName, key);
		if (list == null || list.size() == 0) {
			System.out.println("缓存中没有数据，需要从数据库读取");
			LayIMDao dao = new LayIMDao();
			List<String> memebers = dao.getMemberListOnlyIds(groupId);
			saveGroupMemeberIds(groupId, memebers);
			return memebers;
		} else {
			System.out.println("直接从缓存中读取出来");
		}
		return list;
	}
}