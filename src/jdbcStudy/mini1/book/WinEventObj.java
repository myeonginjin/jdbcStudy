package jdbcStudy.mini1.book;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinEventObj extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	} // windowClosing

} // class
