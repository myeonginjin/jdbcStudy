package jdbcStudy.mini1.swing.level1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class FrameTest {
	
	public JFrame frm;
	
	public FrameTest () {
		frm = new JFrame("제목은 여기에...");
	}
	
	public void makeGui() {
		frm.setSize(450,450);
		frm.setVisible(true);
	}
	
	public void addEvent() {
		frm.addWindowListener(new WindowAdapter() {
									public void windowClosing(WindowEvent e) {
										System.exit(0);
									} //windowClosing
								} //new WindowAdapter
		
		); //addWindowListener
	} //addEvent
	
	public static void main(String[] args) {
		FrameTest ft = new FrameTest();
		ft.makeGui();
		ft.addEvent();
	}

}
