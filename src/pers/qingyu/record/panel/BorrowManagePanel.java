package pers.qingyu.record.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.redis.operate.StudentFileOperate;
import pers.qingyu.record.system.io.DBIO;
import pers.qingyu.record.util.GUIUtil;
import pers.qingyu.record.util.RedisUtil;

public class BorrowManagePanel extends JPanel implements Serializable {

	/**
	 * 本类为借阅权限管理面板
	 */
	public static BorrowManagePanel instance = new BorrowManagePanel();
	private ChosePanel choseList = null;
	private TextArea area = new TextArea();
	private JScrollPane areaPanel = new JScrollPane(area);

	public BorrowManagePanel() {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 40, 980, 595);
		this.setBackground(Color.gray);
	}

	public void setElements() {
		areaPanel.setBounds(150, 1, 830, 560);
		this.add(areaPanel);

		choseList = new ChosePanel();
		choseList.setBounds(0, 1, 149, 598);
		this.add(choseList);
	}

	class ChosePanel extends JPanel implements ActionListener {

		private JButton manageTeacherRoot = new JButton("管理教师档案");
		private JButton manageStaffRoot = new JButton("管理员工档案");
		private JButton manageStudentRoot = new JButton("管理学生档案");
		private JButton addStudentRoot = new JButton("添加学生档案");
		private JButton addTeacherRoot = new JButton("添加教师档案");
		private JButton addStaffRoot = new JButton("添加员工档案");
		private JButton delStudentRoot = new JButton("清空学生档案");
		private JButton delTeacherRoot = new JButton("清空教师档案");
		private JButton delStaffRoot = new JButton("清空员工档案");

		public ChosePanel() {
			this.setVisible(true);
			this.setLayout(new FlowLayout(0, 12, 30));
			this.setElements();
		}

		private void setElements() {
			GUIUtil.setJButton(this, manageStudentRoot, 120, 22);
			GUIUtil.setJButton(this, manageTeacherRoot, 120, 22);
			GUIUtil.setJButton(this, manageStaffRoot, 120, 22);
			GUIUtil.setJButton(this, addStudentRoot, 120, 22);
			GUIUtil.setJButton(this, addTeacherRoot, 120, 22);
			GUIUtil.setJButton(this, delStudentRoot, 120, 22);
			GUIUtil.setJButton(this, delTeacherRoot, 120, 22);
			GUIUtil.setJButton(this, delStaffRoot, 120, 22);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b.equals(manageStudentRoot)) {
				area.setText(DBIO.getValue());
			} else if (b.equals(manageTeacherRoot)) {
				String rangeString = JOptionPane.showInputDialog("输入转移需要转移数据的学号范围");
			} else if (b.equals(manageStaffRoot)){
				String rangeString = JOptionPane.showInputDialog("输入转移需要转移数据的学号范围");
			} else if (b.equals(addStudentRoot)) {
				String rangeString = JOptionPane.showInputDialog("输入转移需要转移数据的学号范围");
				int start = Integer.parseInt(rangeString.split(" ")[0]);
				int end = Integer.parseInt(rangeString.split(" ")[1]);
				ArrayList<StudentFile> files = RecordSerchPanel.instance.studentFiles;
				for (StudentFile file : files) {
					if (file.getNumber() >= start && file.getNumber() <= end) {
						StudentFileOperate.putStudentFile(file);
						area.append(file.toString() + "\n");
						DBIO.writeValue(file.toString());
					}
				}
			}else if (b.equals(delStudentRoot)) {
				StudentFileOperate.deleteAll();
//				StudentFileOperate.removeAllFile(RecordSerchPanel.instance.studentFiles);
				area.setText("");
			}
		}
	}
}
