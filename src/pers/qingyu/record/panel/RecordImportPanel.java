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
	 * ����Ϊ�û����뵵�����
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
		private JButton importStudent = new JButton("����ѧ���ļ�");
		private JButton importTeacher = new JButton("�����ʦ�ļ�");
		private JButton importStaff = new JButton("����Ա���ļ�");
		private JButton importTxt = new JButton("����(.text)�ļ�");
		private JButton importHtml = new JButton("����(.html)�ļ�");
		private JButton importDbf = new JButton("����(.dbf)�ļ�");
		private JButton importDb = new JButton("����(.db)�ļ�");
		private JButton importCxv = new JButton("����(.Cxv)�ļ�");
		private JButton importXlsx = new JButton("����(.xlsx)�ļ�");

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
				String path = GUIUtil.getSelectLoadPath("ѡ��ѧ���ļ�");
				IOUtil.writeStudentToFile(studentService.getAllStudent(), path);
			} else if (b.equals(importTeacher)) {
				TeacherService teacherService = new TeacherService();
				String path = GUIUtil.getSelectLoadPath("ѡ���ʦ�ļ�");
				IOUtil.writeTeacherToFile(teacherService.getAllTeacher(), path);
			} else if (b.equals(importStaff)) {
				StaffService staffService = new StaffService();
				String path = GUIUtil.getSelectLoadPath("ѡ��Ա���ļ�");
				IOUtil.writeStaffToFile(staffService.getAllStaff(), path);
			}
		}
	}
}
