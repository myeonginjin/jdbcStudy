package jdbcStudy.mini1.swing.level1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinEventTest implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opended");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
		
	}

}
