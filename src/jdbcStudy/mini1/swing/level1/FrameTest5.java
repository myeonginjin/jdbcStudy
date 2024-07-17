package jdbcStudy.mini1.swing.level1;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import org.xml.sax.HandlerBase;

public class FrameTest5 {
	
	public JFrame frm;
	public JButton btn1, btn2;
	public JTextField tf1, tf2;
	public ActionEventTest aet;
	
	public FrameTest5 () {
		frm = new JFrame("제목은 여기에...");
		tf1 = new JTextField();
		tf2 = new JTextField();
		btn1 = new JButton("ToDown");
		btn2 = new JButton("ToUp");
		aet = new ActionEventTest(tf1, tf2);
	}
	
	public void makeGui() {
		frm.setSize(450,450);
		frm.setLayout(null);
		
		tf1.setBounds(10, 20, 200, 30);
		tf2.setBounds(10, 70, 200, 30);
		btn1.setBounds(240, 20, 100, 30);
		btn2.setBounds(240, 70, 100, 30);
		
		
		frm.add(tf1);
		frm.add(tf2);
		
		frm.add(btn1);
		frm.add(btn2);
		frm.setVisible(true);
	}
	
	public void addEvent() {
		frm.addWindowListener(new WindowAdapter() {
									public void windowClosing(WindowEvent e) {
										System.exit(0);
									} //windowClosing
								} //new WindowAdapter
		
		); //addWindowListener
		btn1.addActionListener(aet);
		btn2.addActionListener(aet);
	} //addEvent
	
	public static void main(String[] args) {
		FrameTest5 ft = new FrameTest5();
		ft.makeGui();
		ft.addEvent();
	}

}
