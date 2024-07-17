package jdbcStudy.mini1.swing.level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ActionEventTest implements ActionListener {
	
	public JTextField memberTextField1, memberTextField2;
	
	public ActionEventTest(JTextField tf1 , JTextField tf2) {
		memberTextField1 = tf1;
		memberTextField2 = tf2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("ToDown")) {
			memberTextField2.setText(memberTextField1.getText());
			memberTextField1.setText("");
		} else if (command.equals("ToUp")) {
			memberTextField1.setText(memberTextField2.getText());
			memberTextField2.setText("");
		}
		
		
	}
	
}
