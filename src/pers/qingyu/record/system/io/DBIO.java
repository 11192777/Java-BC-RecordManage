package pers.qingyu.record.system.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pers.qingyu.record.util.DBUtil;

public class DBIO {

	public static void writeValue(String value) {
		String sql = "insert into redis_value (file_value) value (?)";

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = (Connection) DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);	
			
			psmt.setString(1, value);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}

	public static String getValue() {
		String sql = "select * from redis_value";
		StringBuffer sb = new StringBuffer();

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {
				sb.append(resultSet.getString("file_value") + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return sb.toString();
	}
	
	public static void delValue () {
		String sql = "delete from redis_value";
		StringBuffer sb = new StringBuffer();

		Connection conet = null;
		PreparedStatement psmt = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			psmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}
}
