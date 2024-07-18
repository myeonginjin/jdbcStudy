package searchBookSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import searchBookSystem.DAOList;


public class ControllerList extends MouseAdapter implements ActionListener {

	DAOList dao;

	/* ViewList - 목록보기 화면 */
	JTable table;
	TableColumnModel colModel;
	Vector<String> colNames;


	String selectedBookid;

	ControllerList() {}

	ControllerList(JTable intable) {
		dao = new DAOList();
		int connectYN = dao.connect();
		if(connectYN <= 0) {
			System.out.println("연결 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			return;
		}

		/* ViewList - 목록보기 화면 */
		table = intable;
		colNames = new Vector<String>();
		colNames.add("bookid"); colNames.add("bookname");
		colNames.add("publisher"); colNames.add("price");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
//		int rowIndex = table.getSelectedRow();
//		if(rowIndex !=-1) {
//			TableModel tableModel = table.getModel();
//			selectedBookid = (String) tableModel.getValueAt(rowIndex, 0);
//			viewUp.tfBookName.setText( (String) tableModel.getValueAt(rowIndex, 1) );
//			viewUp.tfPublisher.setText( (String) tableModel.getValueAt(rowIndex, 2) );
//			viewUp.tfPrice.setText( (String) tableModel.getValueAt(rowIndex, 3) );
//		}
//		viewUp.setVisible(true);
	} // mouseClicked

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if(cmd.equals("목록 조회")) { // dao에서 도서 리스트를 Vector로 조회 후, JTable에 넣어 준다.
			this.readAll();
		}
	} // actionPerformed

	private void readAll() {
		Vector<Vector<String>> bookVector = dao.readAll();
		if(bookVector == null) {
			System.out.println("조회 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			return;
		}

//		DefaultTableModel model = new DefaultTableModel(colNames, 0);
//		table.setModel(model);
//		for(Vector<String> tmpVector : bookVector) {
//			model.addRow(tmpVector);
//		}
		/* 상기 5줄처럼 하셔도 되고, 하기 2줄처럼 하셔도 됩니다. */
		DefaultTableModel model = new DefaultTableModel(bookVector, colNames);
		table.setModel(model);
	} // readAll

	public void connectionClose() {
		int closeYN = dao.close();
		if(closeYN <= 0) {
			System.out.println("연결 해제 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			return;
		}
	} // connectionClose

} // class