package pers.qingyu.record.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pers.qingyu.record.po.TeacherFile;
import pers.qingyu.record.util.DBUtil;

public class TeacherDao {
	public void addTeacherFile(TeacherFile teacher) {
		String sql = "insert into teacher_file (teacher_number, teacher_name, teacher_sex, teacher_nation,"
				+ "teacher_major, teacher_idnumber, teacher_birthday, start_date) value (?,?,?,?,?,?,?,?)";

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, teacher.getNumber());
			psmt.setString(2, teacher.getName());
			psmt.setString(3, teacher.getSex());
			psmt.setString(4, teacher.getNation());
			psmt.setString(5, teacher.getMajor());
			psmt.setString(6, teacher.getIdnumber());
			psmt.setDate(7, teacher.getBirthday());
			psmt.setDate(8, teacher.getStartDate());

			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}
	}

	public void deleteTeacherFile(String teacherNumber) {
		String sql = "delete from teacher_file where teacher_number = " + teacherNumber;

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

	public TeacherFile loadTeacherFile(String teacherNumber) {
		String sql = "select * from teacher_file where teacher_number = " + teacherNumber;

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		TeacherFile teacher = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				teacher = new TeacherFile(resultSet.getLong("teahcer_number"), resultSet.getDate("start_date"),
						resultSet.getString("teacher_name"), resultSet.getString("teacher_sex"),
						resultSet.getString("teacher_nation"), resultSet.getString("teacher_major"),
						resultSet.getString("teacher_idnumber"), resultSet.getDate("teacher_birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}

		return teacher;
	}

	public ArrayList<TeacherFile> loadAllTeachers() {
		String sql = "select * from teacher_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		ArrayList<TeacherFile> teachers = new ArrayList<TeacherFile>();
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {
				teachers.add(new TeacherFile(resultSet.getLong("teacher_number"), resultSet.getDate("start_date"),
						resultSet.getString("teacher_name"), resultSet.getString("teacher_sex"),
						resultSet.getString("teacher_nation"), resultSet.getString("teacher_major"),
						resultSet.getString("teacher_idnumber"), resultSet.getDate("teacher_birthday")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return teachers;
	}

	public int getTeacherCount(int startAge, int endAge) {
		String sql = "select count(*) from teacher_file where teacher_number > ? && teacher_number < ?";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		int number = -1;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, startAge * 1000);
			psmt.setLong(2, endAge * 1000);

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

	public int getTeacherMinAge() {
		String sql = "select min(teacher_number) from teacher_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		long number = -1;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				number = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return (int) (number / 1000);
	}

	public int getTeacherMaxAge() {
		String sql = "select max(teacher_number) from teacher_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		long number = -1;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				number = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return (int) (number / 1000);
	}
}
