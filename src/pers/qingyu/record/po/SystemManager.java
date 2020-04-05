package pers.qingyu.record.po;

public class SystemManager {
	/* ����Ϊϵͳ����Ա�࣬�������Զ������£���������Ϊ�����������ݿ�-recordManage �б�-system_manager
	 * ����Ӧ�ֶ�����
	 * 
	 * ѧ�� ��student_number��
	 * ���� ��student_name��
	 * �Ա� ��student_sex��
	 */ 
	public static final String MANAGER_NAME = "����Ա";
	
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
