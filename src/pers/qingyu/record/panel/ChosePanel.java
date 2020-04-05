package pers.qingyu.record.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pers.qingyu.record.frame.MainFrame;
import pers.qingyu.record.util.GUIUtil;

public class ChosePanel extends JPanel implements ActionListener {
	/*
	 * ChosePanel类为主面板中的选择栏
	 */
	private static final Dimension CHOSE_PANEL = new Dimension(980, 40);
	private static final FlowLayout CHOSE_PANEL_LAYOUT = new FlowLayout(1, 30, 8);

	public static ChosePanel instance = new ChosePanel();

	private JButton search = new JButton("档案查询");
	private JButton gradeManage = new JButton("借阅管理");
	private JButton cartogram = new JButton("档案统计");
	private JButton fileImport = new JButton("档案导入");
	private JButton backups = new JButton("备份档案");

	private ChosePanel() {
		this.setSize(CHOSE_PANEL);
		this.setLayout(CHOSE_PANEL_LAYOUT);
		this.setVisible(true);
	}

	public void setElements() {
		GUIUtil.setJButton(ChosePanel.instance, this.search, 0, 0);
		GUIUtil.setJButton(ChosePanel.instance, this.gradeManage, 0, 0);
		GUIUtil.setJButton(ChosePanel.instance, this.cartogram, 0, 0);
		GUIUtil.setJButton(ChosePanel.instance, this.fileImport, 0, 0);
		GUIUtil.setJButton(ChosePanel.instance, this.backups, 0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if (b.equals(search)) {
			MainFrame.instance.changeMainExhibit(RecordSerchPanel.instance);
		} else if (b.equals(gradeManage)) {
			MainFrame.instance.changeMainExhibit(BorrowManagePanel.instance);
		} else if (b.equals(cartogram)) {
			MainFrame.instance.changeMainExhibit(RecordShowPanel.instance);
		} else if (b.equals(fileImport)) {
			MainFrame.instance.changeMainExhibit(RecordImportPanel.instance);
		} else if (b.equals(backups)) {
			MainFrame.instance.changeMainExhibit(RecordBackupPanel.instance);
		} else {
//			null
		}
	}

}
