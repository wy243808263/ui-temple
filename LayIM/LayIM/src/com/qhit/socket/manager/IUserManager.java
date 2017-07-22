package com.qhit.socket.manager;

import com.qhit.pojo.SocketUser;

/**
 * 用户业务层
 * 
 * @author Administrator
 * 
 */
public interface IUserManager {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 */
	boolean addUser(SocketUser user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 */
	boolean removeUser(SocketUser user);

	/**
	 * 统计用户在线状态
	 * 
	 * @return 数量
	 */
	int getOnlineCount();

	/**
	 * 根据用户编号获取用户
	 * 
	 * @param userId
	 *            用户编号
	 * @return 用户信息
	 */
	SocketUser getUser(int userId);
}