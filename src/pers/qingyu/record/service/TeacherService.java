package pers.qingyu.record.service;

import java.util.ArrayList;

import pers.qingyu.record.dao.TeacherDao;
import pers.qingyu.record.po.TeacherFile;

public class TeacherService {

	public ArrayList<TeacherFile> getAllTeacher() {
		TeacherDao dao = new TeacherDao();
		return dao.loadAllTeachers();
	}
	
	public void addTeacherFile (TeacherFile teacher) {
		TeacherDao dao = new TeacherDao();
		dao.addTeacherFile(teacher);
	}

	public int getTeacherCount(int startAge, int endAge) {
		TeacherDao dao = new TeacherDao();
		return dao.getTeacherCount(startAge, endAge);
	}

	public int getTeacherMinAge() {
		TeacherDao dao = new TeacherDao();
		return dao.getTeacherMinAge();
	}

	public int getTeacherMaxAge() {
		TeacherDao dao = new TeacherDao();
		return dao.getTeacherMaxAge();
	}
}
