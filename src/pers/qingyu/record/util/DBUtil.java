package pers.qingyu.record.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	/*
	 * DBUtilΪ�����࣬������Ϊ���ݿ�������һЩ������Ϣ����װ��һЩ��ȡ������������ӵķ���
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

//	��ȡ���ݿ����ӻỰ�����getConnection����
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
		System.out.println("���ӳɹ�...");
	}

}
