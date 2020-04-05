package pers.qingyu.record.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.util.DBUtil;

public class StudentDao {

	public void addStudentFile(StudentFile student) {
		String sql = "insert into student_file (student_number,student_name,student_sex,student_nation,"
				+ "student_major,student_idnumber,student_birthday, start_date) value (?,?,?,?,?,?,?,?)";

		Connection conet = null;
		PreparedStatement psmt = null;

		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, student.getNumber());
			psmt.setString(2, student.getName());
			psmt.setString(3, student.getSex());
			psmt.setString(4, student.getNation());
			psmt.setString(5, student.getMajor());
			psmt.setString(6, student.getIdnumber());
			psmt.setDate(7, student.getBirthday());
			psmt.setDate(8, student.getStartDate());

			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, null, psmt);
		}

	}

	public void deleteStudentFile(long studentNumber) {
		String sql = "delete from student_file where student_number = " + studentNumber;

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

	public StudentFile loadStudentFile(long studentNumber) {
		String sql = "select * from student_file where student_number = " + studentNumber;

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		StudentFile student = null;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				student = new StudentFile(resultSet.getLong("student_number"), resultSet.getDate("start_date"),
						resultSet.getString("student_name"), resultSet.getString("student_sex"),
						resultSet.getString("student_nation"), resultSet.getString("student_major"),
						resultSet.getString("student_idnumber"), resultSet.getDate("student_birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return student;
	}

	public ArrayList<StudentFile> loadAllStuent() {
		String sql = "select * from student_file";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		ArrayList<StudentFile> students = new ArrayList<StudentFile>();
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);
			resultSet = psmt.executeQuery();

			while (resultSet.next()) {
				students.add(new StudentFile(resultSet.getLong("student_number"), resultSet.getDate("start_date"),
						resultSet.getString("student_name"), resultSet.getString("student_sex"),
						resultSet.getString("student_nation"), resultSet.getString("student_major"),
						resultSet.getString("student_idnumber"), resultSet.getDate("student_birthday")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAllConnection(conet, resultSet, psmt);
		}
		return students;
	}

	public int getStudentCount(int startAge, int endAge) {
		String sql = "select count(*) from student_file where student_number > ? && student_number < ?";

		Connection conet = null;
		PreparedStatement psmt = null;
		ResultSet resultSet = null;

		int number = -1;
		try {
			conet = DBUtil.getConnection();
			psmt = conet.prepareStatement(sql);

			psmt.setLong(1, startAge * 10000);
			psmt.setLong(2, endAge * 10000);

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

	public int getStudentMinAge() {
		String sql = "select min(student_number) from student_file";

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
		return (int) (number / 10000);
	}

	public int getStudentMaxAge() {
		String sql = "select max(student_number) from student_file";

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
		return (int) (number / 10000);
	}
}
