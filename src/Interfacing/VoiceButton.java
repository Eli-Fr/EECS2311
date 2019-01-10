package Interfacing;

import java.awt.Image;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VoiceButton extends ProgrammableButton {

	private String name;

	// no arg constructor
	public VoiceButton() {

	}

	public VoiceButton(String name, Image I) {
		this.name = name;
		this.setIcon(new ImageIcon(I));
//		this.update(g);
	}

	public void output() {
	//	AudioInputStream I = Audiosystem.;
	}
}
