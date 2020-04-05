package export;


import java.sql.Date;

import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.service.StudentService;

public class StudentExport{
	
	public static void main(String[] args) {
		StudentService ss = new StudentService();
		for (int i = 1;i<=10000;i++) {
			ss.addStudentFile(new StudentFile(i, new Date(1567267200000l), BuildUtil.getName(), BuildUtil.getSex(), BuildUtil.getNation(), BuildUtil.getMajor(), "2301841999" + i, new Date(1567267200000l)));
			System.out.println(i);
		}
	}
}
