package com.qhit.dao.operate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qhit.dao.db.IResultSetOperate;
import com.qhit.util.log.LayIMLog;

/**
 * 获取用户成员选项
 * 
 * @author Administrator
 * 
 */
public class LayIMGetMemberIdsOperate implements IResultSetOperate {
	public Object getObject(ResultSet resultSet) {
		List<String> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}
		} catch (SQLException ex) {
			LayIMLog.error(ex);
		}
		return list;
	}

	public Object getObject(Statement statement) {
		return null;
	}
}