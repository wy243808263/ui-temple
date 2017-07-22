package com.qhit.pojo;

import javax.websocket.Session;

/**
 * 用户通信协议实体类
 * 
 * @author Administrator
 * 
 */
public class SocketUser {
	private Session session;
	private int userId;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getUserId() {
		return userId;
	}

	public boolean isExist() {
		return this.userId > 0;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return session.getId() + "_" + userId;
	}
}