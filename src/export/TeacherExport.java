package export;


import java.sql.Date;

import pers.qingyu.record.po.TeacherFile;
import pers.qingyu.record.service.TeacherService;

public class TeacherExport {
	public static void main(String[] args) {
		TeacherService ts = new TeacherService();
		for (int i = 2019001;i<2019009;i++) {
			ts.addTeacherFile(new TeacherFile(i, new Date(317577960000l), BuildUtil.getName(), BuildUtil.getSex(), BuildUtil.getNation(), BuildUtil.getMajor(), "230184" + i + "1234", new Date(317577960000l)));
		}
	}
}
