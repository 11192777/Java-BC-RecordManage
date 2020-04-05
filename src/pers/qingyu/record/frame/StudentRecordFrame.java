package pers.qingyu.record.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.system.io.SystemFileIO;
import pers.qingyu.record.util.GUIUtil;

public class StudentRecordFrame extends JFrame implements ActionListener{
	private StudentFile file;
	private JTextArea area = new JTextArea();
	private JButton exportToExcel = new JButton("������Excel���");
	private JButton exportToWord = new JButton("������Word�ĵ�");

	public StudentRecordFrame(StudentFile studentFile) {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.file = studentFile;
		this.setElements();
	}

	public void setElements() {
		area.setBounds(0, 0, 800, 400);
		area.setEditable(false);
		area.setFont(new Font("����",Font.BOLD,23));
		area.append("ѧ��:" + new Long(file.getNumber()).toString());
		area.append("\n����:" + file.getName());
		area.append("\n�Ա�" + file.getSex());
		area.append("\n����" + file.getNation());
		area.append("\nרҵ" + file.getMajor());
		area.append("\n����" + file.getBirthday().toString());
		area.append("\n���֤��" + file.getIdnumber());
		this.add(area);
		
		exportToExcel.addActionListener(this);
		exportToExcel.setBounds(0, 500, 200, 30);
		this.add(exportToExcel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(exportToExcel)) {
			String path = GUIUtil.getSelectSavePath("ѡ�񱣴�·��");
			ArrayList<StudentFile> files = new ArrayList<StudentFile>();
			files.add(this.file);
			if(path != null) {
				SystemFileIO.outPutFileToExcel(files, path);
			}
		}
	}
}
