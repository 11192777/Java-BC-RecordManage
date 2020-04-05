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

public class RecordBackupPanel extends JPanel {

	/**
	 * ����Ϊ�����������
	 */
	public static RecordBackupPanel instance = new RecordBackupPanel();
	private ChosePanel choseList = null;

	public RecordBackupPanel() {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 40, 980, 595);
		this.setBackground(Color.gray);
	}

	public void setElements() {
		choseList = new ChosePanel();
		choseList.setBounds(0, 1, 159, 598);
		this.add(choseList);
	}

	class ChosePanel extends JPanel implements ActionListener {
		private JButton backupStudentFile = new JButton("����ѧ������������");
		private JButton backupTeacherFile = new JButton("���ݽ�ʦ����������");
		private JButton backupStaffFile = new JButton("����Ա������������");
		private JButton backupStudentNet = new JButton("����ѧ������������");
		private JButton backupStaffNet = new JButton("����Ա������������");
		private JButton backupTeacherNet = new JButton("���ݽ��ҵ���������");

		public ChosePanel() {
			this.setVisible(true);
			this.setLayout(new FlowLayout(0, 10, 30));
			this.setElements();
		}

		private void setElements() {
			GUIUtil.setJButton(this, backupStudentFile, 140, 22);
			GUIUtil.setJButton(this, backupTeacherFile, 140, 22);
			GUIUtil.setJButton(this, backupStaffFile, 140, 22);
			GUIUtil.setJButton(this, backupStudentNet, 140, 22);
			GUIUtil.setJButton(this, backupTeacherNet, 140, 22);
			GUIUtil.setJButton(this, backupStaffNet, 140, 22);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b.equals(backupStudentFile)) {
				StudentService studentService = new StudentService();
				String path = GUIUtil.getSelectSavePath("ѡ�񱸷�·��");
				if (path != null) {
					IOUtil.writeStudentToFile(studentService.getAllStudent(), path);
				}
			} else if (b.equals(backupTeacherFile)) {
				TeacherService teacherService = new TeacherService();
				String path = GUIUtil.getSelectSavePath("ѡ�񱸷�·��");
				if (path != null) {
					IOUtil.writeTeacherToFile(teacherService.getAllTeacher(), path);
				}
			} else if (b.equals(backupStaffFile)) {
				StaffService staffService = new StaffService();
				String path = GUIUtil.getSelectSavePath("ѡ�񱸷�·��");
				if (path != null) {
					IOUtil.writeStaffToFile(staffService.getAllStaff(), path);
				}
			}
		}
	}
}
