package com.qhit.pojo;

/**
 * 用户实体类
 * 
 * @author Administrator
 * 
 */
public class User {

	private int id;// 用户编号
	private int fgid;//
	private String sign;// 在线状态
	private String avatar;// 图片地址
	private String username;// 用户名称

	public int getFgid() {
		return fgid;
	}

	public void setFgid(int fgid) {
		this.fgid = fgid;
	}

	public User() {

	}

	public User(int id, String username, String sign, String avatar) {
		this.id = id;
		this.username = username;
		this.sign = sign;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

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
}