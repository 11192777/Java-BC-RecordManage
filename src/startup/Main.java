package startup;

import pers.qingyu.record.frame.MainFrame;
import pers.qingyu.record.frame.PassWordFrame;

public class Main {
	public static void main(String[] args) {
		new PassWordFrame(); 
		MainFrame.instance.setPanels();
	}
}