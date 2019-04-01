package TBC_Interface;

import javax.swing.JOptionPane;

public class ShowError {
	public void errorMessage(String e) {
		JOptionPane.showMessageDialog(null, e, "Confirm Exit", JOptionPane.ERROR_MESSAGE);
	}
}
