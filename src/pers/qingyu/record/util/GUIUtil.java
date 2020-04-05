package pers.qingyu.record.util;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import pers.qingyu.record.panel.RecordSerchPanel;
import pers.qingyu.record.system.object.MyJButton;

public class GUIUtil {
	/*
	 * GUIUtil为面板工具类，封装了一些面板中组件的定义方法
	 */
	public static final Font FANGSONG_14 = new Font("仿宋", Font.BOLD, 15);

	public static void setJButton(JPanel wall, JButton b, int width, int height) {
		if (width != 0 && height != 0) {
			b.setPreferredSize(new Dimension(width, height));
		}
		b.addActionListener((ActionListener) wall);
		b.setFocusable(false);
		wall.add(b);
	}

	public static JButton getMyJButton(JPanel wall, String title, int width, int height, int index) {
		MyJButton b = new MyJButton(title);
		b.index = index;
		if (width != 0 && height != 0) {
			b.setPreferredSize(new Dimension(width, height));
		}
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyJButton b = (MyJButton) e.getSource();
				RecordSerchPanel.instance.showUserInformation(b.index);
			}
		});
		b.setHorizontalAlignment(JButton.LEFT);
		b.setFont(new Font("黑体", Font.BOLD, 12));
		b.setFocusable(false);
		wall.add(b);
		return b;
	}

	public static void useSkin() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getSelectSavePath(String title) {
		FileDialog fd = new FileDialog(new JFrame(), title, FileDialog.SAVE);
		fd.setVisible(true);
		if (fd.getFile() == null) {
			return null;
		}
		return fd.getDirectory() + fd.getFile();
	}

	public static String getSelectLoadPath(String title) {
		FileDialog fd = new FileDialog(new JFrame(), title, FileDialog.SAVE);
		fd.setVisible(true);
		return fd.getDirectory() + fd.getFile();
	}

}
