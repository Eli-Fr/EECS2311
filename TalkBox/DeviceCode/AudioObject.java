package DeviceCode;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AudioObject {

	private String name;

	public AudioObject(String name) {
		this.name = name;
	}

	public void playSound() {

		try {
			AudioPlayer.player.start(
					new AudioStream(new FileInputStream("C:\\TalkBox\\TalkBoxData\\Audio\\" + this.name)));

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No Audio File Found for Button: " + getName(), "Okay",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public String getName() {
		return this.name;
	}

}
