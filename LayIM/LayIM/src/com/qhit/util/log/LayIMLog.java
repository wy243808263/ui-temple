package com.qhit.util.log;

import org.apache.log4j.Logger;

/**
 * 日志工具类
 * 
 * @author Administrator
 * 
 */
public class LayIMLog {

	static Logger logger = Logger.getLogger(LayIMLog.class);

	/**
	 * 错误消息
	 * 
	 * @param msg
	 *            消息
	 */
	public static void error(Object msg) {
		logger.error(msg);
	}

	/**
	 * 信息日志
	 * 
	 * @param msg
	 *            消息
	 */
	public static void info(Object msg) {
		logger.info(msg);
	}
}