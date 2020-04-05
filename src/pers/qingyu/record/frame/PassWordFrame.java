package pers.qingyu.record.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import pers.qingyu.record.po.SystemManager;
import pers.qingyu.record.service.ManagerService;
import pers.qingyu.record.util.GUIUtil;

public class PassWordFrame extends JFrame {

	private JPasswordField passWordText = new JPasswordField();
	private JLabel lable = new JLabel("输入管理密码：");
	private JButton sure = new JButton("确认");

	public PassWordFrame() {
		this.setTitle("密码验证");
		this.setVisible(true);
		this.setSize(450, 120);
		this.setLayout(null);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setElement();
	}

	public void setElement() {
		this.lable.setBounds(20, 20, 95, 30);
		this.passWordText.setBounds(110, 20, 180, 30);
		this.sure.setBounds(300, 20, 80, 30);
		sure.setFocusable(false);
		this.add(lable);
		this.add(passWordText);
		this.add(sure);
		
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ManagerService service = new ManagerService();
				SystemManager manager = service.getManager("admin");
				if (new String(passWordText.getPassword()).equals(manager.getPassword())) {
					MainFrame.instance.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"密码错误","提示框",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
