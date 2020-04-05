package pers.qingyu.record.util;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

import pers.qingyu.record.po.StaffFile;
import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.po.TeacherFile;
import pers.qingyu.record.service.StaffService;
import pers.qingyu.record.service.StudentService;
import pers.qingyu.record.service.TeacherService;
import pers.qingyu.record.system.object.BarCharDataBase;

public class BarChartUtil {
	private static final String TITLE = "档案数据";
	private static final String CATEGORy_AXIS_LABEL = "";
	private static final String VALUE_AXIS_LABEL = "数量";

	public static JPanel getBarChartPanel(int color, ArrayList<BarCharDataBase> values) {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

		for (BarCharDataBase b : values) {
			dataSet.addValue(b.getAmount(), b.getTitle(), b.getCategoryAxisLabel());
		}

		JFreeChart chart = ChartFactory.createBarChart3D(TITLE, CATEGORy_AXIS_LABEL, VALUE_AXIS_LABEL, dataSet,
				PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		BarRenderer3D rander = new BarRenderer3D();
		rander.setItemMargin(0.001);  
		rander.setMaximumBarWidth(0.05);
		if (color == 1) {
			rander.setSeriesPaint(0, Color.red);
		}else if (color == 2) {
			rander.setSeriesPaint(0, Color.blue);
		}else if (color == 3){
			rander.setSeriesPaint(0, Color.green);
		}else {
			rander.setSeriesPaint(0, Color.red);
			rander.setSeriesPaint(1, Color.blue);
			rander.setSeriesPaint(2, Color.green);
		}
		plot.setRenderer(rander);
		plot.setForegroundAlpha(0.6f);
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14));
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

		return new ChartPanel(chart, true);
	}

	public static ArrayList<BarCharDataBase> getAllUserValues() {
		ArrayList<BarCharDataBase> values = new ArrayList<BarCharDataBase>();

		StudentService studentService = new StudentService();
		TeacherService teacherService = new TeacherService();
		StaffService staffService = new StaffService();

		values.add(new BarCharDataBase(
				studentService.getStudentCount(studentService.getStudentMinAge(), studentService.getStudentMaxAge()),
				StudentFile.STUDENT_NAME, ""));
		values.add(new BarCharDataBase(
				teacherService.getTeacherCount(teacherService.getTeacherMinAge(), teacherService.getTeacherMaxAge()),
				TeacherFile.TEACHER_NAME, ""));
		values.add(new BarCharDataBase(
				staffService.getStaffCount(staffService.getStaffMinAge(), staffService.getStaffMaxAge()),
				StaffFile.STAFF_NAME, ""));
		return values;
	}

	public static ArrayList<BarCharDataBase> getStudentBarValues() {
		ArrayList<BarCharDataBase> values = new ArrayList<BarCharDataBase>();
		StudentService studentService = new StudentService();

		for (int i = studentService.getStudentMinAge(); i <= studentService.getStudentMaxAge(); i++) {
			values.add(new BarCharDataBase(studentService.getStudentCount(i, i + 1), StudentFile.STUDENT_NAME,
					Integer.toString(i)));
		}
		return values;
	}

	public static ArrayList<BarCharDataBase> getTeacherBarValues() {
		ArrayList<BarCharDataBase> values = new ArrayList<BarCharDataBase>();
		TeacherService teacherService = new TeacherService();

		for (int i = teacherService.getTeacherMinAge(); i <= teacherService.getTeacherMaxAge(); i++) {
			if (teacherService.getTeacherCount(i, i + 1) != 0) {
				values.add(new BarCharDataBase(teacherService.getTeacherCount(i, i + 1), TeacherFile.TEACHER_NAME,
						Integer.toString(i)));
			}
		}
		return values;
	}

	public static ArrayList<BarCharDataBase> getStaffBarValues() {
		ArrayList<BarCharDataBase> values = new ArrayList<BarCharDataBase>();
		StaffService staffService = new StaffService();
		System.out.println(staffService.getStaffMinAge());
		System.out.println(staffService.getStaffMaxAge());

		for (int i = staffService.getStaffMinAge() ; i <= staffService.getStaffMaxAge(); i++) {
			if (staffService.getStaffCount(i, i + 1) != 0) {
				values.add(new BarCharDataBase(staffService.getStaffCount(i, i + 1), StaffFile.STAFF_NAME,
						Integer.toString(i)));
			}
		}
		return values;
	}

}