package pers.qingyu.record.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pers.qingyu.record.service.StaffService;
import pers.qingyu.record.service.StudentService;
import pers.qingyu.record.service.TeacherService;
import pers.qingyu.record.util.GUIUtil;
import pers.qingyu.record.util.IOUtil;

public class RecordImportPanel extends JPanel {

	/**
	 * 奔类为用户导入档案面板
	 */
	public static RecordImportPanel instance = new RecordImportPanel();

	private ChosePanel choseList = null;

	public RecordImportPanel() {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 40, 980, 595);
		this.setBackground(Color.gray);
	}

	public void setElements() {
		choseList = new ChosePanel();
		choseList.setBounds(0, 1, 149, 598);
		this.add(choseList);
	}

	class ChosePanel extends JPanel implements ActionListener {
		private JButton importStudent = new JButton("导入学生文件");
		private JButton importTeacher = new JButton("导入教师文件");
		private JButton importStaff = new JButton("导入员工文件");
		private JButton importTxt = new JButton("导入(.text)文件");
		private JButton importHtml = new JButton("导入(.html)文件");
		private JButton importDbf = new JButton("导入(.dbf)文件");
		private JButton importDb = new JButton("导入(.db)文件");
		private JButton importCxv = new JButton("导入(.Cxv)文件");
		private JButton importXlsx = new JButton("导入(.xlsx)文件");

		public ChosePanel() {
			this.setVisible(true);
			this.setLayout(new FlowLayout(0, 10, 30));
			this.setElements();
		}

		private void setElements() {
			GUIUtil.setJButton(this, importStudent, 125, 22);
			GUIUtil.setJButton(this, importTeacher, 125, 22);
			GUIUtil.setJButton(this, importStaff, 125, 22);
			GUIUtil.setJButton(this, importTxt, 125, 22);
			GUIUtil.setJButton(this, importHtml, 125, 22);
			GUIUtil.setJButton(this, importDb, 125, 22);
			GUIUtil.setJButton(this, importDbf, 125, 22);
			GUIUtil.setJButton(this, importXlsx, 125, 22);
			GUIUtil.setJButton(this, importCxv, 125, 22);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b.equals(importStudent)) {
				StudentService studentService = new StudentService();
				String path = GUIUtil.getSelectLoadPath("选择学生文件");
				IOUtil.writeStudentToFile(studentService.getAllStudent(), path);
			} else if (b.equals(importTeacher)) {
				TeacherService teacherService = new TeacherService();
				String path = GUIUtil.getSelectLoadPath("选择教师文件");
				IOUtil.writeTeacherToFile(teacherService.getAllTeacher(), path);
			} else if (b.equals(importStaff)) {
				StaffService staffService = new StaffService();
				String path = GUIUtil.getSelectLoadPath("选择员工文件");
				IOUtil.writeStaffToFile(staffService.getAllStaff(), path);
			}
		}
	}
}
