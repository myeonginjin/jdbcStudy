package mini2.book_t;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewUpdate extends JFrame {

	JLabel labelBookName, labelPublisher, labelPrice;
	JTextField tfBookName, tfPublisher, tfPrice;
	JButton btnUpdate, btnDelete, btnCancel;
	BorderLayout border;
	JPanel panBtn, panIns;

	ViewUpdate() {
		panBtn = new JPanel();
		panIns = new JPanel();
		border = new BorderLayout();
		labelBookName = new JLabel("BookName");
		labelPublisher = new JLabel("Publisher");
		labelPrice = new JLabel("Price");
		tfBookName = new JTextField();
		tfPublisher = new JTextField();
		tfPrice = new JTextField();
		btnUpdate = new JButton("도서 수정");
		btnDelete = new JButton("도서 삭제");
		btnCancel = new JButton("현재창닫기");
	}

	public void makeGui() {
		setTitle("도서 정보 수정/삭제");
		setSize(500, 500);
		setLayout(border);
		add(panIns, BorderLayout.CENTER);
		panIns.setLayout(null);
		panIns.add(labelBookName); panIns.add(labelPublisher); panIns.add(labelPrice);
		panIns.add(tfBookName); panIns.add(tfPublisher); panIns.add(tfPrice);
		labelBookName.setBounds(10, 10, 100, 35);
		labelPublisher.setBounds(10, 50, 100, 35);
		labelPrice.setBounds(10, 90, 100, 35);
		tfBookName.setBounds(120, 10, 300, 35);
		tfPublisher.setBounds(120, 50, 300, 35);
		tfPrice.setBounds(120, 90, 300, 35);
		add(panBtn, BorderLayout.SOUTH);
		panBtn.add(btnUpdate); panBtn.add(btnDelete); panBtn.add(btnCancel);
	}

	public void addEvent(ControllerList controller) {
		btnUpdate.addActionListener(controller);
		btnDelete.addActionListener(controller);
		btnCancel.addActionListener(controller);
	}

	public void closeEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

} // class








