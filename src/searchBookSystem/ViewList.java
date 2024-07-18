package searchBookSystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewList {

	JFrame frm;
	BorderLayout border;
	JPanel panBtn, panSearch;
	JButton btnAdd, btnReadAll, btnSearch;
	JScrollPane scollPan;
	JTable table;

	JTextField tfName, tfPublisher, tfMinPrice, tfMaxPrice;

	ControllerList controller;

	ViewList() {
		frm = new JFrame("도서 관리 프로그램");
		border = new BorderLayout();
		panBtn = new JPanel();
		panSearch = new JPanel(new GridLayout(2, 4));

		btnAdd = new JButton("도서 추가");
		btnReadAll = new JButton("목록 조회");
		btnSearch = new JButton("검색");

		tfName = new JTextField();
		tfPublisher = new JTextField();
		tfMinPrice = new JTextField();
		tfMaxPrice = new JTextField();

		table = new JTable();
		scollPan = new JScrollPane(table);
		controller = new ControllerList(table, tfName, tfPublisher, tfMinPrice, tfMaxPrice);
	}

	public void makeGui() {
		frm.setSize(800, 600);
		frm.setLayout(border);

		panSearch.add(new JLabel("이름:"));
		panSearch.add(tfName);
		panSearch.add(new JLabel("출판사:"));
		panSearch.add(tfPublisher);
		panSearch.add(new JLabel("최소 가격:"));
		panSearch.add(tfMinPrice);
		panSearch.add(new JLabel("최대 가격:"));
		panSearch.add(tfMaxPrice);
		panSearch.add(new JLabel(""));
		panSearch.add(btnSearch);

		frm.add(scollPan, BorderLayout.CENTER);
		frm.add(panSearch, BorderLayout.NORTH);
		frm.add(panBtn, BorderLayout.SOUTH);

		panBtn.add(btnAdd);
		panBtn.add(btnReadAll);

		frm.setVisible(true);
	}

	public void addEvent() {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd.addActionListener(controller);
		btnReadAll.addActionListener(controller);
		btnSearch.addActionListener(controller);
		table.addMouseListener(controller);

		controller.readAll();
	}

	public static void main(String[] args) {
		ViewList vl = new ViewList();
		vl.makeGui();
		vl.addEvent();
	}
}
