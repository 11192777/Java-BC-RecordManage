package export;


import java.sql.Date;
import java.util.Calendar;

import pers.qingyu.record.po.StaffFile;
import pers.qingyu.record.service.StaffService;

public class StaffExport {
	public static void main(String[] args) {
		StaffService ss = new StaffService();
		for (int i = 1; i < 389; i++) {
			long time = StaffExport.getYearLong();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(time));
			ss.addStaffFile(
					new StaffFile(cal.get(Calendar.YEAR) * 100000 + i, new Date(time), BuildUtil.getName(), BuildUtil.getSex(),
							BuildUtil.getNation(), null, "230184199" + i, new Date(time)));
			System.out.println(i);
		}
	}
	
	public static long getYearLong () {
		long[] time = new long[] {948729960000l,980352360000l,1011888360000l,1043424360000l,1074960360000l,1106582760000l,1138118760000l,1169654760000l};
		return time[(int) (Math.random() * time.length)];
	}
}
