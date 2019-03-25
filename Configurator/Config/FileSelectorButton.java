package Config;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FileSelectorButton extends JButton implements ActionListener {

	/**
	 * 
	 */

	private String name;
	private static final long serialVersionUID = 1L;

	public FileSelectorButton(String text, String name) {
		super(text);
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == FileSelectorButton.class) {
			FileSelectorButton FB = (FileSelectorButton) e.getSource();
			if (FB.getName().equals("Audio")) {
				FileDialog fd = new FileDialog(new JFrame());
			}
		}

	}

	public String getName() {
		return this.name;
	}

}
