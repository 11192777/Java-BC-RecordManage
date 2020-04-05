package pers.qingyu.record.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pers.qingyu.record.frame.StaffRecordFrame;
import pers.qingyu.record.frame.StudentRecordFrame;
import pers.qingyu.record.frame.TeacherRecordFrame;
import pers.qingyu.record.po.StaffFile;
import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.po.TeacherFile;
import pers.qingyu.record.service.StaffService;
import pers.qingyu.record.service.StudentService;
import pers.qingyu.record.service.TeacherService;
import pers.qingyu.record.system.io.SystemFileIO;
import pers.qingyu.record.util.GUIUtil;

public class RecordSerchPanel extends JPanel implements MouseListener, ActionListener {
	public static RecordSerchPanel instance = new RecordSerchPanel();
	private ChosePanel choseList = new ChosePanel();

	private JTextField findText = new JTextField(10);
	private JButton findButton = new JButton("搜索");

	public static ArrayList<StudentFile> studentFiles = new ArrayList<StudentFile>();
	public static ArrayList<StaffFile> staffFiles = new ArrayList<StaffFile>();
	public static ArrayList<TeacherFile> teacherFiles = new ArrayList<TeacherFile>();

	private JPanel informationsListPanel = new JPanel();
	private JScrollPane allInfors = new JScrollPane(informationsListPanel);

	private JPopupMenu menu = new JPopupMenu();
	private JMenuItem[] items = new JMenuItem[] { new JMenuItem("按姓名查找"), new JMenuItem("按专业查找") };

	private ArrayList<StudentFile> showStudentFile = new ArrayList<StudentFile>();
	private int chose;

	/**
	 * 改类为档案查询面板
	 */
	public RecordSerchPanel() {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 40, 980, 595);
	}

	public void setElements() {
		findText.setBounds(2, 10, 95, 22);
		this.add(findText);
		findButton.setBounds(101, 10, 58, 22);
		findButton.setFocusable(false);
		findButton.addMouseListener(this);
		this.add(findButton);

		choseList = new ChosePanel();
		choseList.setBounds(0, 45, 159, 595);
		this.add(choseList);

		informationsListPanel.setLayout(new FlowLayout(0, -2, -2));
		this.setListValues();

		allInfors.setBounds(160, 12, 810, 595);
		allInfors.getVerticalScrollBar().setUnitIncrement(20);
		this.add(allInfors);

		for (int i = 0; i < items.length; i++) {
			menu.add(items[i]);
			items[i].addActionListener(this);
		}
	}

	public void setListValues() {
		StudentService studentService = new StudentService();
		studentFiles = studentService.getAllStudent();

		TeacherService teacherService = new TeacherService();
		teacherFiles = teacherService.getAllTeacher();

		StaffService staffService = new StaffService();
		staffFiles = staffService.getAllStaff();
	}

	public void setListPanelStudentFile(ArrayList<StudentFile> files) {
		informationsListPanel.removeAll();
		informationsListPanel.setPreferredSize(new Dimension(820, files.size() * 28));
		for (int i = 0; i < files.size(); i++) {
			informationsListPanel.add(GUIUtil.getMyJButton(informationsListPanel, files.get(i).toString(), 790, 30, i));
		}
		informationsListPanel.updateUI();
		this.chose = 0;
	}

	public void setListPanelTeacherFile(ArrayList<TeacherFile> files) {
		informationsListPanel.removeAll();
		informationsListPanel.setPreferredSize(new Dimension(820, files.size() * 28));
		for (int i = 0; i < files.size(); i++) {
			informationsListPanel.add(GUIUtil.getMyJButton(informationsListPanel, files.get(i).toString(), 790, 30, i));
		}
		informationsListPanel.updateUI();
		this.chose = 1;
	}

	public void setListPanelStaffFile(ArrayList<StaffFile> files) {
		informationsListPanel.removeAll();
		informationsListPanel.setPreferredSize(new Dimension(820, files.size() * 28));
		for (int i = 0; i < files.size(); i++) {
			informationsListPanel.add(GUIUtil.getMyJButton(informationsListPanel, files.get(i).toString(), 790, 30, i));
		}
		informationsListPanel.updateUI();
		this.chose = 2;
	}

	public void showUserInformation(int index) {
		if (this.chose == 0) {
			new StudentRecordFrame(studentFiles.get(index));
		} else if (this.chose == 1) {
			new TeacherRecordFrame(teacherFiles.get(index));
		} else {
			new StaffRecordFrame(staffFiles.get(index));
		}
	}

	class ChosePanel extends JPanel implements ActionListener {
		private JButton showStudent = new JButton("学生档案");
		private JButton showTeacher = new JButton("教师档案");
		private JButton showStaff = new JButton("员工档案");
		private JButton loadFile = new JButton("打印全部");

		public ChosePanel() {
			this.setVisible(true);
			this.setLayout(new FlowLayout(0, 30, 20));
			this.setElements();
		}

		private void setElements() {
			GUIUtil.setJButton(this, showStudent, 0, 0);
			GUIUtil.setJButton(this, showTeacher, 0, 0);
			GUIUtil.setJButton(this, showStaff, 0, 0);
			GUIUtil.setJButton(this, loadFile, 0, 0);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b.equals(showStudent)) {
				setListPanelStudentFile(studentFiles);
				showStudentFile = studentFiles;
			} else if (b.equals(showTeacher)) {
				setListPanelTeacherFile(teacherFiles);
			} else if (b.equals(showStaff)) {
				setListPanelStaffFile(staffFiles);
			} else {
				String path = GUIUtil.getSelectSavePath("选择保存路径");
				if (path != null && showStudentFile != null) {
					SystemFileIO.outPutFileToExcel(showStudentFile, path);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if (b.equals(this.findButton)) {
			menu.show(e.getComponent(), findButton.getX() - 50, findButton.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (findText.getText().equals("")) {
			informationsListPanel.removeAll();
			informationsListPanel.updateUI();
			return;
		}

		if (e.getSource().equals(this.items[0])) {
			if (this.chose == 0) {
				ArrayList<StudentFile> stufile = new ArrayList<StudentFile>();
				for (StudentFile s : studentFiles) {
					if (s.getName().contains(findText.getText())) {
						stufile.add(s);
					}
				}
				this.showStudentFile = stufile;
				setListPanelStudentFile(stufile);
			} else if (this.chose == 1) {
				ArrayList<TeacherFile> teafile = new ArrayList<TeacherFile>();
				for (TeacherFile t : teacherFiles) {
					if (t.getName().contains(findText.getText())) {
						teafile.add(t);
					}
				}
				setListPanelTeacherFile(teafile);
			} else {
				ArrayList<StaffFile> stafile = new ArrayList<StaffFile>();
				for (StaffFile f : staffFiles) {
					if (f.getName().contains(findText.getText())) {
						stafile.add(f);
					}
				}
				setListPanelStaffFile(stafile);
			}
		} else {
			if (this.chose == 0) {
				ArrayList<StudentFile> stufile = new ArrayList<StudentFile>();
				for (StudentFile s : studentFiles) {
					if (s.getMajor().contains(findText.getText())) {
						stufile.add(s);
					}
				}
				this.showStudentFile = stufile;
				setListPanelStudentFile(stufile);
			} else if (this.chose == 1) {
				ArrayList<TeacherFile> teafile = new ArrayList<TeacherFile>();
				for (TeacherFile t : teacherFiles) {
					if (t.getMajor().contains(findText.getText())) {
						teafile.add(t);
					}
				}
				setListPanelTeacherFile(teafile);
			} else {
				ArrayList<StaffFile> stafile = new ArrayList<StaffFile>();
				for (StaffFile f : staffFiles) {
					if (f.getMajor().contains(findText.getText())) {
						stafile.add(f);
					}
				}
				setListPanelStaffFile(stafile);
			}
		}
	}

}
