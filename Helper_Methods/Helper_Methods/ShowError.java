package Helper_Methods;

import javax.swing.JOptionPane;

public class ShowError {
	public static void errorMessage(String e) {
		JOptionPane.showMessageDialog(null, e, "Confirm Exit", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void errorMessageOK(String e) {
		JOptionPane.showMessageDialog(null, e, "Okay", JOptionPane.ERROR_MESSAGE);
	}
}
