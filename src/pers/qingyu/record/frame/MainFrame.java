package pers.qingyu.record.frame;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pers.qingyu.record.panel.BorrowManagePanel;
import pers.qingyu.record.panel.ChosePanel;
import pers.qingyu.record.panel.RecordBackupPanel;
import pers.qingyu.record.panel.RecordImportPanel;
import pers.qingyu.record.panel.RecordSerchPanel;
import pers.qingyu.record.panel.RecordShowPanel;
import pers.qingyu.record.util.GUIUtil;

public class MainFrame extends JFrame {

	/*
	 * MainFrame为档案管理系统的主面板
	 */

	static {
		GUIUtil.useSkin();
	}

//	主窗体大小
	private static Dimension MAINFRAME = new Dimension(980, 635);

	public static MainFrame instance = new MainFrame();
	private ArrayList<JPanel> panels;

	private MainFrame() {
		this.setLayout(null);
		this.setSize(MAINFRAME);
		this.setResizable(false);
		this.panels = new ArrayList<>();
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	加载Frame窗体所需要的所有组件
	public void setPanels() {
		ChosePanel.instance.setElements();
		BorrowManagePanel.instance.setElements();
		RecordSerchPanel.instance.setElements();
		RecordBackupPanel.instance.setElements();
		RecordShowPanel.instance.setElements();
		RecordImportPanel.instance.setElements();

		this.add(ChosePanel.instance);
		this.add(RecordSerchPanel.instance);
		this.add(BorrowManagePanel.instance);
		this.add(RecordShowPanel.instance);
		this.add(RecordImportPanel.instance);
		this.add(RecordBackupPanel.instance);

		this.panels.add(BorrowManagePanel.instance);
		this.panels.add(RecordBackupPanel.instance);
		this.panels.add(RecordSerchPanel.instance);
		this.panels.add(RecordShowPanel.instance);
		this.panels.add(RecordImportPanel.instance);
	}

//	changeMainExhibit方法为通过用户点击不同按钮从而显示不同的操作界面
	public void changeMainExhibit(JPanel p) {
		for (JPanel panel : this.panels) {
			if (!panel.equals(p)) {
				panel.setVisible(false);
			} else {
				panel.setVisible(true);
			}
		}
	}
}
