package pers.qingyu.recordmanage.pojo;

import java.io.Serializable;
import java.sql.Date;

public class TeacherFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public static final String TEACHER_NAME = "ΩÃ ¶";
	
	private int number;
	private Date startDate;
	private String name;
	private String sex;
	private String nation;
	private String major;
	private String idnumber;
	private Date birthday;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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
}
