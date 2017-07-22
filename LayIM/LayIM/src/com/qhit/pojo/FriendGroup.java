package com.qhit.pojo;

import java.util.List;

/**
 * 朋友组实体类
 * 
 * @author Administrator
 * 
 */
public class FriendGroup extends Group {

	private int online;
	private List<User> list;

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}