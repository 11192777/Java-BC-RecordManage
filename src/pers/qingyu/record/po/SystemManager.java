package pers.qingyu.record.po;

public class SystemManager {
	/* 该类为系统管理员类，其类属性定义如下：（括号内为该属性在数据库-recordManage 中表-system_manager
	 * 中相应字段名）
	 * 
	 * 学号 （student_number）
	 * 姓名 （student_name）
	 * 性别 （student_sex）
	 */ 
	public static final String MANAGER_NAME = "管理员";
	
	private String id;
	private String password;
	private int grade;

	public SystemManager(String id, String password, int grade) {
		this.id = id;
		this.password = password;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String toString () {
		return "ID:" + this.id + "\nPassWord:" + this.password + "\nGrade:"  + this.grade;
	}
}
