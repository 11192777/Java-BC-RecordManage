package pers.qingyu.record.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	/*
	 * DBUtil为工具类，其属性为数据库连接中一些配置信息并封装了一些获取与管理数据连接的方案
	 * @author: QingyuMeng
	 */
	public static String ip = "127.0.0.1";
	public static int port = 3306;
	public static String dataBase = "test1";
	public static String encoding = "utf-8";
	public static String loginName = "root";
	public static String passWord = "root";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//	获取数据库连接会话对象的getConnection方法
	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, dataBase, encoding);
		return (Connection) DriverManager.getConnection(url, loginName, passWord);
	}
	
	public static void main(String[] args) {
		try {
			Connection con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("连接成功...");
	}

}
