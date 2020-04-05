package pers.qingyu.record.frame;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressFrame extends JFrame {

//	static {
//		GUIUtil.useSkin();
//	}

	private JProgressBar progressBar = new JProgressBar();
	private int maxValue;

	public ProgressFrame() {
		this.setSize(400, 100);
		this.setUndecorated(true);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		progressBar.setIndeterminate(false);
		progressBar.setStringPainted(true);
		this.add(progressBar);
		this.setVisible(false);
	}

	public void setValue(int value) {
		progressBar.setValue(value);
		if (value == this.maxValue) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
		}
	}
	
	public void setProgressValue (int minValue, int maxValue) {
		progressBar.setMinimum(minValue);
		progressBar.setMaximum(maxValue);
		this.maxValue = maxValue;
		progressBar.updateUI();
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		ProgressFrame s = new ProgressFrame(0, 100);
//		for (int i =0;i<=100;i++) {
//			s.setValue(i);
//		}
//	}
}