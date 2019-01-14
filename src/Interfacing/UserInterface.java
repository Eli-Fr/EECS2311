package Interfacing;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserInterface extends JOptionPane implements ActionListener {
	// these components are for when the changer is implemented
	private ArrayList<VoiceButton> listOfButtons = new ArrayList<VoiceButton>();
	private int NumberOfButtons;
	private int maxNumberOfButtons;

	public UserInterface(int max) {
		maxNumberOfButtons = max;
		File f = new File("src/interfacing/labels.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		for (int i = 0; i < max; i++) {
			listOfButtons.add(new VoiceButton(sc.nextLine(), null));

		}
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
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
