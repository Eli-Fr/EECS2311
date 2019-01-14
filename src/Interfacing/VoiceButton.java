package Interfacing;

import java.awt.Image;
import javax.swing.ImageIcon;

public class VoiceButton extends ProgrammableButton {

	private String name;

	// no arg constructor
	public VoiceButton() {

	}

	public VoiceButton(String name, Image I) {
		this.name = name;
		this.setText(name);
//		this.update(g);
	}

	public void output() {
	}
}
