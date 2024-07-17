package jdbcStudy.mini1.swing.level2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ActionEventObj implements ActionListener {
	
	public JTextField tf1;
	public ActionEventObj() {}
	
	public ActionEventObj(JTextField intf1) {
		this.tf1 = intf1;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("CLS")) {
			tf1.setText("");
			
		} else if (cmd.equals("+")) {
			
		}else if (cmd.equals("-")) {
			
		}else if (cmd.equals("*")) {
			
		}else if (cmd.equals("/")) {
			
		} else {
			tf1.setText(cmd);
		}
		
		
	}

}
