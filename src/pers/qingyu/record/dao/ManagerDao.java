package pers.qingyu.record.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pers.qingyu.record.po.SystemManager;
import pers.qingyu.record.util.DBUtil;

public class ManagerDao {
	/*
	 * ManagerDao类为 Manager类提供持久化对象的接口与数据库操作方法
	 */

	public void addManager(SystemManager manager) {
		String sql = "insert into system_manager value (?,?,?,null,null)";

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setString(1, manager.getId());
			psmt.setString(2, manager.getPassword());
			psmt.setInt(3, manager.getGrade());

			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			writeToErrorFile  JDBC.error
			System.out.println("is JDBC.error");
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}

	public void deleteManager(String id) {
		String sql = "delete from system_manager where manager_id = " + id;

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

	public void updateManager(String id, SystemManager manager) {

		String sql = "update system_manager set manager_id = ? , manager_password = ? ,"
				+ " manager_grade = ? where manager_id = " + id;

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setString(1, manager.getId());
			psmt.setString(2, manager.getPassword());
			psmt.setInt(3, manager.getGrade());

			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}

	public SystemManager loadManager(String id) {
		String sql = "select * from system_manager where manager_id = '" + id + "'";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		SystemManager manager = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				manager = new SystemManager(resultSet.getString("manager_id"), resultSet.getString("manager_password"),
						resultSet.getInt("manager_grade"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catchblock
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}

		return manager;
	}
	

	public static void main(String[] args) {
		ManagerDao dao = new ManagerDao();
		SystemManager manager = dao.loadManager("11192777");
		System.out.println(manager.toString());
	}
}
