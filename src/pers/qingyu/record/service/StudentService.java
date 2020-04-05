package pers.qingyu.record.service;

import java.util.ArrayList;

import pers.qingyu.record.dao.StudentDao;
import pers.qingyu.record.po.StudentFile;

public class StudentService {

	public ArrayList<StudentFile> getAllStudent() {
		StudentDao dao = new StudentDao();
		return dao.loadAllStuent();
	}
	
	public void addStudentFile(StudentFile student) {
		StudentDao dao = new StudentDao();
		dao.addStudentFile(student);
	}

	public int getStudentCount(int startAge, int endAge) {
		StudentDao dao = new StudentDao();
		return dao.getStudentCount(startAge, endAge);
	}

	public int getStudentMinAge () {
		StudentDao dao = new StudentDao();
		return dao.getStudentMinAge();
	}
	
	public int getStudentMaxAge () {
		StudentDao dao = new StudentDao();
		return dao.getStudentMaxAge();
	}
	
	public static void main(String[] args) {
		StudentService ss = new StudentService();
		System.out.println(ss.getStudentCount(0, 9999));
	}
}
