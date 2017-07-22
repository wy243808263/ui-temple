package com.qhit.pojo.result;

import java.util.List;

import com.qhit.pojo.User;

/**
 * 用户成员组结果实体类
 * 
 * @author Administrator
 * 
 */
public class GroupMemberResult {

	private User owner;// 用户
	private List<User> list;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}