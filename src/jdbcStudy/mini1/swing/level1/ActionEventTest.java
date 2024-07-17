package jdbcStudy.mini1.swing.level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(e.getActionCommand());
		
	}
	
}
