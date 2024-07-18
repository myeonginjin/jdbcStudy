package searchBookSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ControllerList extends MouseAdapter implements ActionListener {

	DAOList dao;
	JTable table;
	TableColumnModel colModel;
	Vector<String> colNames;

	JTextField tfName, tfPublisher, tfMinPrice, tfMaxPrice;

	String selectedBookid;

	ControllerList(JTable intable, JTextField tfName, JTextField tfPublisher, JTextField tfMinPrice, JTextField tfMaxPrice) {
		dao = new DAOList();
		int connectYN = dao.connect();
		if (connectYN <= 0) {
			System.out.println("연결 오류 입니다. 관리자에게 문의 바랍니다.");
			return;
		}

		this.table = intable;
		this.tfName = tfName;
		this.tfPublisher = tfPublisher;
		this.tfMinPrice = tfMinPrice;
		this.tfMaxPrice = tfMaxPrice;

		colNames = new Vector<>();
		colNames.add("bookid");
		colNames.add("bookname");
		colNames.add("publisher");
		colNames.add("price");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("목록 조회")) {
			this.readAll();
		} else if (cmd.equals("검색")) {
			this.searchBooks();
		}
	}

	public void readAll() {
		Vector<Vector<String>> bookVector = dao.readAll();
		if (bookVector == null) {
			System.out.println("조회 오류 입니다. 관리자에게 문의 바랍니다.");
			return;
		}
		DefaultTableModel model = new DefaultTableModel(bookVector, colNames);
		table.setModel(model);
	}

	public void searchBooks() {
		String name = tfName.getText().trim();
		String publisher = tfPublisher.getText().trim();
		String minPrice = tfMinPrice.getText().trim();
		String maxPrice = tfMaxPrice.getText().trim();

		Vector<Vector<String>> bookVector = dao.searchBooks(name, publisher, minPrice, maxPrice);
		if (bookVector == null) {
			System.out.println("검색 오류 입니다. 관리자에게 문의 바랍니다.");
			return;
		}
		DefaultTableModel model = new DefaultTableModel(bookVector, colNames);
		table.setModel(model);
	}
}
