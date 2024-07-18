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
    Vector<String> colNames;
    JTextField tfName, tfPublisher, tfMinPrice, tfMaxPrice;

    ControllerList(JTable intable, JTextField tfName, JTextField tfPublisher, JTextField tfMinPrice, JTextField tfMaxPrice) {
        dao = new DAOList();
        int connectYN = dao.connect();
        if (connectYN <= 0) {
            System.out.println("연결 오류 입니다. 관리자에게 문의 바랍니다."); // 다이얼로그 구현 필요.
            return;
        }

        table = intable;
        colNames = new Vector<String>();
        colNames.add("bookid");
        colNames.add("bookname");
        colNames.add("publisher");
        colNames.add("price");

        this.tfName = tfName;
        this.tfPublisher = tfPublisher;
        this.tfMinPrice = tfMinPrice;
        this.tfMaxPrice = tfMaxPrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("검색")) {
            searchBooks();
        } else if (cmd.equals("초기화")) {
            resetSearch();
        }
    }

    public void searchBooks() {
        String name = tfName.getText();
        String publisher = tfPublisher.getText();
        String minPrice = tfMinPrice.getText();
        String maxPrice = tfMaxPrice.getText();

        Vector<Vector<String>> bookVector = dao.searchBooks(name, publisher, minPrice, maxPrice);
        if (bookVector == null) {
            System.out.println("조회 오류 입니다. 관리자에게 문의 바랍니다."); // 다이얼로그 구현 필요.
            return;
        }

        DefaultTableModel model = new DefaultTableModel(bookVector, colNames);
        table.setModel(model);
    }

    public void resetSearch() {
        tfName.setText("");
        tfPublisher.setText("");
        tfMinPrice.setText("");
        tfMaxPrice.setText("");
        readAll();
    }

    public void readAll() {
        Vector<Vector<String>> bookVector = dao.readAll();
        if (bookVector == null) {
            System.out.println("조회 오류 입니다. 관리자에게 문의 바랍니다."); // 다이얼로그 구현 필요.
            return;
        }

        DefaultTableModel model = new DefaultTableModel(bookVector, colNames);
        table.setModel(model);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 필요시 구현
    }

    public void connectionClose() {
        int closeYN = dao.close();
        if (closeYN <= 0) {
            System.out.println("연결 해제 오류 입니다. 관리자에게 문의 바랍니다."); // 다이얼로그 구현 필요.
            return;
        }
    }
}
