package com.qhit.socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.qhit.pojo.SocketUser;
import com.qhit.pojo.message.ToServerTextMessage;
import com.qhit.socket.manager.OnLineUserManager;
import com.qhit.socket.sender.MessageSender;
import com.qhit.util.LayIMFactory;

/**
 * 聊天服务类
 * 
 * @author Administrator
 * 
 */
@ServerEndpoint("/websocket/{uid}")
public class LayIMServer {

	/**
	 * 打开用户
	 * 
	 * @param session
	 *            会话
	 * @param uid
	 *            用户编号
	 */
	@OnOpen
	public void open(Session session, @PathParam("uid") int uid) {
		SocketUser user = new SocketUser();
		user.setSession(session);
		user.setUserId(uid);

		// 保存在线列表
		LayIMFactory.createManager().addUser(user);
		print("当前在线用户：" + LayIMFactory.createManager().getOnlineCount());
		print("缓存中的用户个数：" + new OnLineUserManager().getOnLineUsers().size());
	}

	/**
	 * 发送消息
	 * 
	 * @param message
	 *            消息
	 * @param session
	 *            会话
	 */
	@OnMessage
	public void receiveMessage(String message, Session session) {
		ToServerTextMessage toServerTextMessage = LayIMFactory.createSerializer().toObject(message, ToServerTextMessage.class);

		// 得到接收的对象
		MessageSender sender = new MessageSender();

		sender.sendMessage(toServerTextMessage);
	}

	@OnError
	public void error(Throwable t) {
		print(t.getMessage());
	}

	/**
	 * 关闭会话
	 * 
	 * @param session
	 *            会话
	 */
	@OnClose
	public void close(Session session) {
		SocketUser user = new SocketUser();
		user.setSession(session);
		user.setUserId(0);
		print("用户掉线");
		// 移除该用户
		LayIMFactory.createManager().removeUser(user);
		// print("当前在线用户："+LayIMFactory.createManager().getOnlineCount());
	}

	private void print(String msg) {
		System.out.println(msg);
	}
}