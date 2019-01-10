package Interfacing;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class UserInterface extends JFrame implements ActionListener {
	// these components are for when the changer is implemented
	private ArrayList<VoiceButton> listOfButtons = new ArrayList<VoiceButton>();
	private int NumberOfButtons;
	private int maxNumberOfButtons;

	public UserInterface(int max) {
		maxNumberOfButtons = max;
	}

	public void addButton(String name, Image image) {
		if (NumberOfButtons >= maxNumberOfButtons) {
			throw new IllegalStateException();
		} else {
			listOfButtons.add(new VoiceButton(name, image));
			NumberOfButtons++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		if (AE.getSource().getClass().isAssignableFrom(ProgrammableButton.class)) {
			ProgrammableButton source = (ProgrammableButton) AE.getSource();
			source.output();
		}
	}
}
