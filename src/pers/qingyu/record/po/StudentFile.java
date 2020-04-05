package pers.qingyu.record.po;

import java.io.Serializable;
import java.sql.Date;

public class StudentFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 该类为学生档案类，其类属性定义如下：（括号内为该属性在数据库-recordManage 中表 student_file 中字段名）
	 * 
	 * 学号 （student_number） 入学年份 (start_date) 姓名 （student_name） 性别 （student_sex）
	 * 民族（student_nation） 院系（student_department） 专业 （student_major）
	 * 身份证号（student_idumber） 生日（student_birthday）
	 */
	public static final String STUDENT_NAME = "学生";

	private long number;
	private Date startDate;
	private String name;
	private String sex;
	private String nation;
	private String major;
	private String idnumber;
	private Date birthday;

	public StudentFile(long number, Date startDate, String name, String sex, String nation, String major,
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
