package pers.qingyu.record.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pers.qingyu.record.po.StaffFile;
import pers.qingyu.record.util.DBUtil;

public class StaffDao {
	public void addStaffFile(StaffFile staff) {
		String sql = "insert into staff_file (staff_number, staff_name, staff_sex, staff_nation,"
				+ "staff_major, staff_idnumber, staff_birthday, start_date) value (?,?,?,?,?,?,?,?)";

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, staff.getNumber());
			psmt.setString(2, staff.getName());
			psmt.setString(3, staff.getSex());
			psmt.setString(4, staff.getNation());
			psmt.setString(5, staff.getMajor());
			psmt.setString(6, staff.getIdnumber());
			psmt.setDate(7, (Date) staff.getBirthday());
			psmt.setDate(8, (Date) staff.getStartDate());

			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}

	public void deleteStaffFile(String staffNumber) {
		String sql = "delete from staff_file where staff_number = " + staffNumber;

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

	public StaffFile loadStaffFile(String staffNumber) {
		String sql = "select * from staff_file where staff_number = " + staffNumber;

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		StaffFile staff = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				staff = new StaffFile(resultSet.getLong("staff_number"), resultSet.getDate("start_date"),
						resultSet.getString("staff_name"), resultSet.getString("staff_sex"),
						resultSet.getString("staff_nation"), resultSet.getString("staff_major"),
						resultSet.getString("staff_idnumber"), resultSet.getDate("staff_birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return staff;
	}

	public ArrayList<StaffFile> loadAllStaff() {
		String sql = "select * from staff_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		ArrayList<StaffFile> staffs = new ArrayList<StaffFile>();
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {
				staffs.add(new StaffFile(resultSet.getLong("staff_number"), resultSet.getDate("start_date"),
						resultSet.getString("staff_name"), resultSet.getString("staff_sex"),
						resultSet.getString("staff_nation"), resultSet.getString("staff_major"),
						resultSet.getString("staff_idnumber"), resultSet.getDate("staff_birthday")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return staffs;
	}

	public int getStaffCount(int startAge, int endAge) {
		String sql = "select count(*) from staff_file where staff_number > ? && staff_number < ?";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		int number = -1;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, startAge * 100000);
			psmt.setLong(2, endAge * 100000);

			resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				number = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return number;
	}

	public Date getStaffMinAge() {
		String sql = "select min(start_date) from staff_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		Date date = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				date = resultSet.getDate(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return date;
	}

	public Date getStaffMaxAge() {
		String sql = "select max(start_date) from staff_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		Date date = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				date = resultSet.getDate(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return date;
	}
}
