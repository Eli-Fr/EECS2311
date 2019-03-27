package Config;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileSelectorButton extends AbstractButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;

	public FileSelectorButton(ConfigPanel owner, String text, String name) {
		super(owner, name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileSelectorButton FB = (FileSelectorButton) e.getSource();

		if (FB.getName().equals("Audio")) {
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			fileName = fd.getFile();
			try {
				if (fileName.endsWith(".wav")) {
					ConfigPanel owner = (ConfigPanel) this.getOwner();
					owner.setAudioName(fileName);
					owner.UpdateAudio(fileName);
				} else {

					// TODO open give a message indicating that its not a proper file extension
					// JOptionPane.showMessageDialog(arg0, arg1, arg2, arg3);
				}
			} catch (NullPointerException ex) {

			}

		} else if (FB.getName().equals("Image")) {
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			fileName = fd.getFile();
			try {
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
					ConfigPanel owner = (ConfigPanel) this.getOwner();
					owner.setImageName(fileName);
					owner.UpdateImage(fileName);
				}
			} catch (NullPointerException ex) {

			}
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
