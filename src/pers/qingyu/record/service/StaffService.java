package pers.qingyu.record.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import pers.qingyu.record.dao.StaffDao;
import pers.qingyu.record.po.StaffFile;

public class StaffService {

	public ArrayList<StaffFile> getAllStaff() {
		StaffDao dao = new StaffDao();
		return dao.loadAllStaff();
	}

	public void addStaffFile(StaffFile staff) {
		StaffDao dao = new StaffDao();
		dao.addStaffFile(staff);
	}

	public int getStaffCount(int startAge, int endAge) {
		StaffDao dao = new StaffDao();
		return dao.getStaffCount(startAge, endAge);
	}

	public int getStaffMinAge() {
		StaffDao dao = new StaffDao();
		Calendar cal = Calendar.getInstance();
		Date date = dao.getStaffMinAge();
		if (date != null) {
			cal.setTime(date);
		}
		return cal.get(Calendar.YEAR);
	}

	public int getStaffMaxAge() {
		StaffDao dao = new StaffDao();
		Calendar cal = Calendar.getInstance();
		Date date = dao.getStaffMaxAge();
		if (date != null) {
			cal.setTime(date);
		}
		return cal.get(Calendar.YEAR);
	}
}
