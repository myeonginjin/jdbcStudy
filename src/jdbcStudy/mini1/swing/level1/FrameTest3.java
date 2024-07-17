package jdbcStudy.mini1.swing.level1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameTest3 {
	
	public JFrame frm;
	public JPanel pan1,pan2,pan3,pan4,pan5;
	public JButton btn1;
	public BorderLayout border;
		
		public FrameTest3 () {
			
			frm = new JFrame("제목은 여기에 3...");
			pan1 = new JPanel(); pan1.setBackground(Color.BLUE);
			pan2 = new JPanel(); pan2.setBackground(Color.YELLOW);
			pan3 = new JPanel(); pan3.setBackground(Color.black);
			pan4 = new JPanel(); pan4.setBackground(Color.cyan);
			pan5 = new JPanel(); pan5.setBackground(Color.DARK_GRAY);
			btn1 = new JButton("버튼임당 !");
			border = new BorderLayout();
		}
		
		public void makeGui() {
			
			
			frm.setSize(450,450);
			frm.setLayout(border);
			
			pan1.add(btn1);
			
			
			
			frm.add(pan1, BorderLayout.CENTER);
			frm.add(pan2, BorderLayout.NORTH);
			frm.add(pan3, BorderLayout.SOUTH);
			//frm.add(pan4, BorderLayout.CENTER);
			frm.add(pan5, BorderLayout.WEST);
			
			
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
			FrameTest3 ft = new FrameTest3();
			ft.makeGui();
			ft.addEvent();
		}

}

