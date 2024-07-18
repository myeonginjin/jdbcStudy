package searchBookSystem;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewList {

    JFrame frm;
    JPanel panSearch;
    JButton btnSearch, btnReset;
    JScrollPane scrollPan;
    JTable table;

    JTextField tfName, tfPublisher, tfMinPrice, tfMaxPrice;

    ControllerList controller;

    ViewList() {
        frm = new JFrame("도서 관리 프로그램");
        panSearch = new JPanel(new GridBagLayout());

        btnSearch = new JButton("검색");
        btnReset = new JButton("초기화");

        tfName = new JTextField(10);
        tfPublisher = new JTextField(10);
        tfMinPrice = new JTextField(5);  // 최소 가격 필드 크기 조정
        tfMaxPrice = new JTextField(5);  // 최대 가격 필드 크기 조정

        table = new JTable();
        scrollPan = new JScrollPane(table);
        controller = new ControllerList(table, tfName, tfPublisher, tfMinPrice, tfMaxPrice);
    }

    public void makeGui() {
        frm.setSize(800, 600);
        frm.setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 이름 검색 필드와 라벨 추가
        gbc.gridx = 0;
        gbc.gridy = 0;
        panSearch.add(new JLabel("이름:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panSearch.add(tfName, gbc);

        // 세로줄 간의 간격 조정
        gbc.insets = new Insets(5, 40, 5, 5);  // 간격을 넓힘

        // 출판사 검색 필드와 라벨 추가
        gbc.gridx = 2;
        gbc.gridy = 0;
        panSearch.add(new JLabel("출판사:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        panSearch.add(tfPublisher, gbc);

        // 가격 범위 필드와 라벨 추가
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5); // 원래 간격으로 돌아가기
        panSearch.add(new JLabel("가격 범위:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JPanel pricePanel = new JPanel();
        pricePanel.add(tfMinPrice);
        pricePanel.add(new JLabel(" ~ "));
        pricePanel.add(tfMaxPrice);
        panSearch.add(pricePanel, gbc);

        // 세로줄 간의 간격 조정
        gbc.insets = new Insets(5, 40, 5, 5);  // 간격을 넓힘

        // 검색 버튼 추가
        gbc.gridx = 2;
        gbc.gridy = 1;
        panSearch.add(btnSearch, gbc);

        // 초기화 버튼 추가
        gbc.gridx = 3;
        gbc.gridy = 1;
        panSearch.add(btnReset, gbc);

        // 초기화 버튼 크기 조정
        btnReset.setPreferredSize(btnSearch.getPreferredSize());

        frm.add(scrollPan, BorderLayout.CENTER);
        frm.add(panSearch, BorderLayout.NORTH);

        frm.setVisible(true);
    }

    public void addEvent() {
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSearch.addActionListener(controller);
        btnReset.addActionListener(controller);
        table.addMouseListener(controller);

        controller.readAll();
    }

    public static void main(String[] args) {
        ViewList vl = new ViewList();
        vl.makeGui();
        vl.addEvent();
    }
}
