package mini2.book_t;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class ViewList {

	JFrame frm;
	BorderLayout border;
	JPanel panBtn;
	JButton btnAdd, btnReadAll;
	JScrollPane scollPan;
	JTable table;

	ControllerList controller;

	/* ViewInsert - 입력하기 화면 */
	ViewInsert viewIns;

	/* ViewInsert - 수정하기 화면 */
	ViewUpdate viewUp;

	ViewList() {
		frm = new JFrame("도서 관리 프로그램");
		border = new BorderLayout();
		panBtn = new JPanel();
		btnAdd = new JButton("도서 추가");
		btnReadAll = new JButton("목록 조회");
		table = new JTable();
		scollPan = new JScrollPane(table);
		controller = new ControllerList( table );
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.setLayout(border);
		frm.add(scollPan, BorderLayout.CENTER);
		frm.add(panBtn, BorderLayout.SOUTH);
		panBtn.add(btnAdd);
		panBtn.add(btnReadAll);
		frm.setVisible(true);
	}

	public void addEvent() {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd.addActionListener(controller);
		btnReadAll.addActionListener(controller);
		table.addMouseListener(controller);
	} // addEvent

	public void makeViewInsert() { // 도서 입력 화면 만들기.
		viewIns = new ViewInsert();
		viewIns.makeGui();
		viewIns.addEvent(controller);
		controller.shareViewInsert(viewIns);
	}

	public void makeViewUpdate() { // 도서 수정/삭제 화면 만들기.
		viewUp = new ViewUpdate();
		viewUp.makeGui();
		viewUp.addEvent(controller);
		controller.shareViewUpdate(viewUp);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ViewList vl = new ViewList();
				vl.makeGui();
				vl.addEvent();
				vl.makeViewInsert();
				vl.makeViewUpdate();
			}
		});
	} // main

} // class
