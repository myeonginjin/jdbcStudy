package jdbcStudy.mini1.book;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerList implements ActionListener {

	DAOList dao;
	JTable table;
	Vector<String> colNames;
	
	ControllerList(JTable intable) {
		dao = new DAOList();
		table = intable;
		colNames = new Vector<String>();
		colNames.add("bookid"); colNames.add("bookname");
		colNames.add("publisher"); colNames.add("price");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
        if(cmd.equals("목록 조회")) {
            // dao에서 도서 리스트를 Vector로 조회 후, Jtable에 넣어준다.
            Vector<Book> bookVector = dao.readAll();
            Vector<Vector<Object>> data = new Vector<>();

            for (Book book : bookVector) {
                Vector<Object> row = new Vector<>();
                row.add(book.getBookid());
                row.add(book.getBookname());
                row.add(book.getPublisher());
                row.add(book.getPrice());
                data.add(row);
            }

            DefaultTableModel model = new DefaultTableModel(data, colNames);
            table.setModel(model);
			
		} else if(cmd.equals("도서 추가")) {
			
		}		
	}

}
