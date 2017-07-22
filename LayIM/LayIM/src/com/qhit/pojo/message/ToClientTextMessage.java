package com.qhit.pojo.message;

/**
 * 客户端发送消息
 * 
 * @author Administrator
 * 
 */
public class ToClientTextMessage {

	private String username;// 用户名称
	private int id;// 编号
	private String type;// 类型
	private String content;// 内容
	private long timestamp;// 时间
	private String avatar;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ToClientTextMessage [username=" + username + ", id=" + id + ", type=" + type + ", content=" + content + ", timestamp=" + timestamp + "]";
	}
}