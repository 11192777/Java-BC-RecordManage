package pers.qingyu.record.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pers.qingyu.record.util.BarChartUtil;
import pers.qingyu.record.util.GUIUtil;

public class RecordShowPanel extends JPanel {

	/**
	 * 本类为档案数据展示面板
	 */
	public static RecordShowPanel instance = new RecordShowPanel();

	private ChosePanel choseList = null;
	private JPanel allUserBar = null;
	private JPanel studentBar = null;
	private JPanel teacherBar = null;
	private JPanel staffBar = null;

	private JPanel[] bars = null;

	public RecordShowPanel() {
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 40, 980, 595);
		this.setBackground(Color.gray);
	}

	public void setElements() {
		choseList = new ChosePanel();
		choseList.setBounds(0, 1, 149, 598);
		this.add(choseList);

		allUserBar = BarChartUtil.getBarChartPanel(0, BarChartUtil.getAllUserValues());
		allUserBar.setBounds(150, 0, 830, 566);
		this.add(allUserBar);

		studentBar = BarChartUtil.getBarChartPanel(1, BarChartUtil.getStudentBarValues());
		studentBar.setBounds(150, 0, 830, 566);
		this.add(studentBar);

		teacherBar = BarChartUtil.getBarChartPanel(2, BarChartUtil.getTeacherBarValues());
		teacherBar.setBounds(150, 0, 830, 566);
		this.add(teacherBar);

		staffBar = BarChartUtil.getBarChartPanel(3, BarChartUtil.getStaffBarValues());
		staffBar.setBounds(150, 0, 830, 566);
		this.add(staffBar);

		bars = new JPanel[] { allUserBar, studentBar, teacherBar, staffBar };
	}

	private void setPanelsVisible(JPanel p) {
		for (int i = 0; i < this.bars.length; i++) {
			if (bars[i].equals(p)) {
				p.setVisible(true);
			} else {
				bars[i].setVisible(false);
			}
		}
	}

	class ChosePanel extends JPanel implements ActionListener {
		private JButton showAll = new JButton("所有档案");
		private JButton showStudent = new JButton("学生档案");
		private JButton showTeacher = new JButton("教师档案");
		private JButton showStaff = new JButton("员工档案");

		public ChosePanel() {
			this.setVisible(true);
			this.setLayout(new FlowLayout(0, 30, 30));
			this.setElements();
		}

		private void setElements() {
			GUIUtil.setJButton(this, showAll, 0, 0);
			GUIUtil.setJButton(this, showStudent, 0, 0);
			GUIUtil.setJButton(this, showTeacher, 0, 0);
			GUIUtil.setJButton(this, showStaff, 0, 0);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			if (b.equals(this.showAll)) {
				setPanelsVisible(allUserBar);
			} else if (b.equals(this.showStudent)) {
				setPanelsVisible(studentBar);
			} else if (b.equals(this.showTeacher)) {
				setPanelsVisible(teacherBar);
			} else if (b.equals(this.showStaff)) {
				setPanelsVisible(staffBar);
			} else {
//				else
			}
		}
	}
}
