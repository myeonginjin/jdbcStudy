package jdbcStudy.mini1.swing.level1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class FrameTest2 {
	
	public JFrame frm;
	public WinEventTest winEvent;
	
	public FrameTest2 () {
		frm = new JFrame("제목은 여기에...");
		winEvent = new WinEventTest();
		
	}
	
	public void makeGui() {
		frm.setSize(450,450);
		frm.setVisible(true);
	}
	
	public void addEvent() {
		frm.addWindowListener(winEvent);						
	} //addEvent
	
	public static void main(String[] args) {
		FrameTest2 ft = new FrameTest2();
		ft.makeGui();
		ft.addEvent();
	}

}