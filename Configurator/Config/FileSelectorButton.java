package Config;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class FileSelectorButton extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;

	public FileSelectorButton(ConfigPanel owner, String text, String name) {
		super(owner, name);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileSelectorButton FB = (FileSelectorButton) e.getSource();
		if (FB.getName().equals("Audio")) {
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			fileName = fd.getFile();
			if (fileName.endsWith(".wav")) {
				ConfigPanel owner = (ConfigPanel) this.getOwner();
				owner.setAudioName(fileName);
			}
			System.out.println(fileName);
		} else if (FB.getName().equals("Image")) {
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			fileName = fd.getFile();
		}

	}

	public String getFileName() throws NullPointerException {
		if (fileName == null) {
			throw new NullPointerException();
		} else {
			return this.fileName;
		}
	}

}
