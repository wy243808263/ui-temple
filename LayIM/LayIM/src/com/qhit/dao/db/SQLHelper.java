package com.qhit.dao.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库工具类
 * 
 * @author Administrator
 * 
 */
public class SQLHelper {

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	private Connection getConnection() {
		Connection connection = null;
		try {
			// 加载属性文件，读取数据库连接配置信息
			Properties pro = new Properties();
			pro.load(SQLHelper.class.getResourceAsStream("/jdbc.properties"));

			Class.forName(pro.getProperty("jdbc.driver"));
			connection = DriverManager.getConnection(pro.getProperty("jdbc.url"), pro.getProperty("jdbc.username"), pro.getProperty("jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 执行sql语句 UPDATE INSERT DELETE
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return
	 */
	public boolean ExecuteNonquery(String sql, Map<Integer, Object> params) {
		// 获取连接
		Connection connection = getConnection();
		if (connection == null)
			return false;
		PreparedStatement statement = Prepare(connection, sql, params);
		int result = 0;
		try {
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("关闭连接");
			closeAll(connection, statement);
		}
		return result > 0;
	}

	public boolean ExecuteNonquery(String sql) {
		return ExecuteNonquery(sql, null);
	}

	/**
	 * 查询ResultSet 结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @param operate
	 *            选项
	 * @return 对象
	 */
	public Object QueryResult(String sql, Map<Integer, Object> params, IResultSetOperate operate) {
		Connection connection = getConnection();
		PreparedStatement statement = Prepare(connection, sql, params);
		try {
			ResultSet resultSet = statement.executeQuery();
			// 想要获取相应的结果，需要实现IResultOperate接口
			Object object = operate.getObject(resultSet);
			closeAll(connection, statement);
			return object;

		} catch (SQLException ex) {
			ex.printStackTrace();
			closeAll(connection, statement);
			return null;
		}
	}

	/**
	 * 查询多条结果
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @param operate
	 *            选项
	 * @return 对象
	 */
	public Object QueryManyResultWithProcedure(String sql, Map<Integer, Object> params, IResultSetOperate operate) {
		return QueryManyResult("{call " + sql + "}", params, operate);
	}

	/**
	 * 查询多条结果
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @param operate
	 *            选项
	 * @return
	 */
	public Object QueryManyResult(String sql, Map<Integer, Object> params, IResultSetOperate operate) {
		Connection connection = getConnection();
		PreparedStatement statement = Prepare(connection, sql, params);
		try {
			// 想要获取相应的结果，需要实现IResultOperate接口
			Object object = operate.getObject(statement);
			closeAll(connection, statement);
			return object;
		} catch (Exception ex) {
			ex.printStackTrace();
			closeAll(connection, statement);
			return null;
		}
	}

	/**
	 * 调用储存过程
	 * 
	 * @param connection
	 *            连接
	 * @param procedureSql
	 *            语句
	 * @param params
	 *            参数
	 * @return
	 */
	@SuppressWarnings("unused")
	private CallableStatement PrepareByStoreProcedure(Connection connection, String procedureSql, Map<Integer, Object> params) {
		try {
			CallableStatement statement = connection.prepareCall(procedureSql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					statement.setObject(i + 1, params.get(i + 1));
				}
			}
			return statement;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param connection
	 *            连接
	 * @param sql
	 *            语句
	 * @param params
	 *            参数
	 * @return
	 */
	private PreparedStatement Prepare(Connection connection, String sql, Map<Integer, Object> params) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					// get(key)
					statement.setObject(i + 1, params.get(i + 1));
				}
			}
			return statement;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param connection
	 * @param statement
	 */
	private void closeAll(Connection connection, PreparedStatement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}