package pers.qingyu.record.po;

import java.io.Serializable;
import java.sql.Date;

public class TeacherFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/*
	 * 该类为教师档案类，其类属性定义如下：（括号内为该属性在数据库-recordTeacher 中表 teacher_file 中字段名）
	 * 
	 * 学号 （teacher_number
	 * 姓名 （teacher_name）
	 * 性别 （teacher_sex）
	 * 民族 （teacher_nation）
	 * 院系 （teacher_department）
	 * 专业 （teacher_major）
	 * 身份证号（teacher_idumber）
	 * 生日（teacher_birthday）
	 */
	public static final String TEACHER_NAME = "教师";
	
	private long number;
	private Date startDate;
	private String name;
	private String sex;
	private String nation;
	private String major;
	private String idnumber;
	private Date birthday;

	public TeacherFile(long number, Date startDate, String name, String sex, String nation,  String major,
			String idnumber, Date birthday) {
		this.number = number;
		this.startDate = startDate;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.major = major;
		this.idnumber = idnumber;
		this.birthday = birthday;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		String sex = String.format("%-10s", this.sex).replaceAll("\\s", " ");
		String nation = String.format("%-10s", this.nation).replaceAll("\\s", "  ");
		String name = String.format("%-10s", this.name).replaceAll("\\s", "  ");

		StringBuffer sb = new StringBuffer();
		sb.append(this.number + "    " + sex + name + nation + major);
		return sb.toString();
	}
}
