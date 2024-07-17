package jdbcStudy.mini1.swing.level1;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import org.xml.sax.HandlerBase;

public class FrameTest4 {
	
	public JFrame frm;
	public JButton btn1, btn2;
	public FlowLayout flow;
	public ActionEventTest aet;
	
	public FrameTest4 () {
		frm = new JFrame("제목은 여기에...");
		btn1 = new JButton("버튼 1입니다.");
		btn2 = new JButton("버튼 2입니다.");
		flow = new FlowLayout();
		//aet = new ActionEventTest();
	}
	
	public void makeGui() {
		frm.setSize(450,450);
		frm.setLayout(flow);
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
		FrameTest4 ft = new FrameTest4();
		ft.makeGui();
		ft.addEvent();
	}

}
