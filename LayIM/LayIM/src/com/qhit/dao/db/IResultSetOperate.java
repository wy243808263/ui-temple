package com.qhit.dao.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 选项结果接口
 * 
 * @author Administrator
 * 
 */
public interface IResultSetOperate {

	/**
	 * 操作resultSet返回相应的数据
	 * 
	 * @param resultSet
	 *            结果集
	 * @return
	 */
	Object getObject(ResultSet resultSet);

	/**
	 * 操作resultSet返回相应的数据
	 * 
	 * @param statement
	 *            对象
	 * @return
	 */
	Object getObject(Statement statement);
}