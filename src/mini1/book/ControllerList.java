package mini1.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ControllerList extends MouseAdapter implements ActionListener {

	DAOList dao;

	/* ViewList - 목록보기 화면 */
	JTable table;
	TableColumnModel colModel;
	Vector<String> colNames;

	/* ViewInsert - 입력하기 화면 */
	ViewInsert viewIns;

	/* ViewUpdate - 수정하기 화면 */
	ViewUpdate viewUp;
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

	public void shareViewInsert(ViewInsert inview) { // ViewInsert 객체의 주소를 가져온다.
		viewIns = inview;
	}

	public void shareViewUpdate(ViewUpdate inview) { // ViewInsert 객체의 주소를 가져온다.
		viewUp = inview;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		if(rowIndex !=-1) {
			TableModel tableModel = table.getModel();
			selectedBookid = (String) tableModel.getValueAt(rowIndex, 0);
			viewUp.tfBookName.setText( (String) tableModel.getValueAt(rowIndex, 1) );
			viewUp.tfPublisher.setText( (String) tableModel.getValueAt(rowIndex, 2) );
			viewUp.tfPrice.setText( (String) tableModel.getValueAt(rowIndex, 3) );
		}
		viewUp.setVisible(true);
	} // mouseClicked

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if(cmd.equals("목록 조회")) { // dao에서 도서 리스트를 Vector로 조회 후, JTable에 넣어 준다.
			this.readAll();
		} else if(cmd.equals("도서 추가")) {
			viewIns.setVisible(true);
		} else if(cmd.equals("입력 취소")) {
			viewIns.setVisible(false);
		} else if(cmd.equals("도서 저장")) {
			int resultCnt = dao.insertOne(viewIns.tfBookName.getText()
					, viewIns.tfPublisher.getText(), viewIns.tfPrice.getText());
			if(resultCnt <= 0) {
				System.out.println("입력 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			}
			viewIns.tfBookName.setText("");
			viewIns.tfPublisher.setText("");
			viewIns.tfPrice.setText("");
			this.readAll(); // 입력 후 조회 화면 새로 고침.
		} else if(cmd.equals("현재창닫기")) {
			viewUp.setVisible(false);
		} else if(cmd.equals("도서 수정")) {
			int resultCnt = dao.updateOne(selectedBookid, viewUp.tfBookName.getText()
					, viewUp.tfPublisher.getText(), viewUp.tfPrice.getText());
			if(resultCnt <= 0) {
				System.out.println("입력 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			}
			viewUp.setVisible(false);
			this.readAll(); // 입력 후 조회 화면 새로 고침.
		} else if(cmd.equals("도서 삭제")) {
			int resultCnt = dao.deleteOne(selectedBookid);
			if(resultCnt <= 0) {
				System.out.println("입력 오류 입니다. 관리자에게 문의 바랍니다."); // daialog 구현 필요.
			}
			viewUp.setVisible(false);
			this.readAll(); // 입력 후 조회 화면 새로 고침.
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
