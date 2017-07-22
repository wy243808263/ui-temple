package com.qhit.pojo.message;

/**
 * 数据消息
 * 
 * @author Administrator
 * 
 */
public class ToDBMessage {

	private int sendUserId;
	private long groupId;
	private String msg;
	private int chatType;
	private long addTime;
	private int msgType;

	public int getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getChatType() {
		return chatType;
	}

	public void setChatType(int chatType) {
		this.chatType = chatType;
	}

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
}