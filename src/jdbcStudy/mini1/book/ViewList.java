package jdbcStudy.mini1.book;

import java.awt.*;
import javax.swing.*;

public class ViewList {
	
	JFrame frm;
	BorderLayout border;
	JPanel panBtn;
	JButton btnAdd, btnReadAll;
	JTable table;
	ControllerList controller;
	JScrollPane scrollPan;
	
	ViewList() {
		frm = new JFrame("도서 관리 프로그램");
		border = new BorderLayout();
		panBtn = new JPanel();
		btnAdd = new JButton("추가");
		btnReadAll = new JButton("목록 조회");
		table = new JTable();
		scrollPan = new JScrollPane(table);
		controller = new ControllerList(table);
	}
	
	public void makeGui() {
		frm.setSize(500,500);
		frm.setLayout(border);
		frm.add(scrollPan, BorderLayout.CENTER);
		frm.add(panBtn, BorderLayout.SOUTH);
		panBtn.add(btnAdd);
		panBtn.add(btnReadAll);
		frm.setVisible(true);
	}
	
	public void addEvent() {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd.addActionListener(controller);
		btnReadAll.addActionListener(controller);    
	}
	
	public static void main(String[] args) {
		ViewList v1 = new ViewList();
		v1.makeGui();
		v1.addEvent();
		
	}

}
