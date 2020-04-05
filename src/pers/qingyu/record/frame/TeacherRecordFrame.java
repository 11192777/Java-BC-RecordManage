package pers.qingyu.record.frame;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import pers.qingyu.record.po.TeacherFile;

public class TeacherRecordFrame extends JFrame{
	
	private TeacherFile file;
	private JTextArea area = new JTextArea();
	
	public TeacherRecordFrame (TeacherFile teacherFile) {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.file = teacherFile;
		this.setElements();
	}

	public void setElements() {
		area.setBounds(0, 0, 800, 400);
		area.setEditable(false);
		area.setFont(new Font("����",Font.BOLD,23));
		area.append("ѧ��:" + new Long(file.getNumber()).toString());
		area.append("\n����:" + file.getName());
		area.append("\n�Ա�:" + file.getSex());
		area.append("\n����:" + file.getNation());
		area.append("\nרҵ:" + file.getMajor());
		area.append("\n����:" + file.getBirthday().toString());
		area.append("\n���֤��" + file.getIdnumber());
		this.add(area);
	}
}
