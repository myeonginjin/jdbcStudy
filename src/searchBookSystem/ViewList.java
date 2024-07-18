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
    JScrollPane scrollPan;
    JTable table;

    JTextField tfName, tfPublisher, tfMinPrice, tfMaxPrice;

    ControllerList controller;

    ViewList() {
        frm = new JFrame("도서 관리 프로그램");
        border = new BorderLayout();
        panBtn = new JPanel();
        panSearch = new JPanel(new GridLayout(2, 4));  // 2행 4열 그리드 레이아웃으로 변경

        btnAdd = new JButton("도서 추가");
        btnReadAll = new JButton("목록 조회");
        btnSearch = new JButton("검색");

        tfName = new JTextField();
        tfPublisher = new JTextField();
        tfMinPrice = new JTextField(5);  // 최소 가격 필드 크기 조정
        tfMaxPrice = new JTextField(5);  // 최대 가격 필드 크기 조정

        table = new JTable();
        scrollPan = new JScrollPane(table);
        controller = new ControllerList(table, tfName, tfPublisher, tfMinPrice, tfMaxPrice);
    }

    public void makeGui() {
        frm.setSize(800, 600);
        frm.setLayout(border);

        // 이름 검색 필드와 라벨 추가
        panSearch.add(new JLabel("이름:"));
        panSearch.add(tfName);
        panSearch.add(new JLabel("출판사:"));
        panSearch.add(tfPublisher);

        // 가격 범위 필드와 라벨 추가
        panSearch.add(new JLabel("가격 범위:"));
        JPanel pricePanel = new JPanel();
        pricePanel.add(tfMinPrice);
        pricePanel.add(new JLabel(" ~ "));
        pricePanel.add(tfMaxPrice);
        panSearch.add(pricePanel);
        
        // 검색 버튼 추가
        panSearch.add(new JLabel(""));
        panSearch.add(btnSearch);

        frm.add(scrollPan, BorderLayout.CENTER);
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
