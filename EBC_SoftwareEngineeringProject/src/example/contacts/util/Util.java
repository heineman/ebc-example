package example.contacts.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class Util {
	
	/**
	 * Center frame in display.
	 *  
	 * @param f   Frame to be centered.
	 */
	public static void centerFrame(Window w) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation(dim.width/2 - w.getSize().width/2, dim.height/2 - w.getSize().height/2);
	}
}
