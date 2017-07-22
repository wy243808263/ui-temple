package com.qhit.pojo.result;

import java.util.List;

import com.qhit.pojo.BigGroup;
import com.qhit.pojo.FriendGroup;
import com.qhit.pojo.StatusUser;

/**
 * 这个类主要是对应于layim初始化的数据接口，里面包含mine，friend，group数据
 * 
 * @author Administrator
 * 
 */
public class BaseDataResult {

	private StatusUser mine;
	private List<FriendGroup> friend;
	private List<BigGroup> group;

	public StatusUser getMine() {
		return mine;
	}

	public void setMine(StatusUser mine) {
		this.mine = mine;
	}

	public List<FriendGroup> getFriend() {
		return friend;
	}

	public void setFriend(List<FriendGroup> friend) {
		this.friend = friend;
	}

	public List<BigGroup> getGroup() {
		return group;
	}

	public void setGroup(List<BigGroup> group) {
		this.group = group;
	}
}