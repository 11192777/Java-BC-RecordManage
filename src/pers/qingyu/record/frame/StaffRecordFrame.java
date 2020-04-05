package pers.qingyu.record.frame;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import pers.qingyu.record.po.StaffFile;

public class StaffRecordFrame extends JFrame {
	private JTextArea area = new JTextArea();
	private StaffFile file;

	public StaffRecordFrame(StaffFile staffFile) {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.file = staffFile;
		this.setElements();
	}

	public void setElements() {
		area.setBounds(0, 0, 800, 400);
		area.setEditable(false);
		area.setFont(new Font("宋体",Font.BOLD,23));
		area.append("学号:" + new Long(file.getNumber()).toString());
		area.append("\n姓名:" + file.getName());
		area.append("\n性别" + file.getSex());
		area.append("\n民族" + file.getNation());
		area.append("\n专业" + file.getMajor());
		area.append("\n生日" + file.getBirthday().toString());
		area.append("\n身份证号" + file.getIdnumber());
		this.add(area);
	}

}
