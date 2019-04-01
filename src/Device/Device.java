package Device;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Timer;

/**
 * This class acts as the code that would be running on a physical raspberry PI
 * This includes: file Management, Serialization and Playing Audio
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 *
 */
public class Device {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of Aliases for the program to reference during calls
	 */
	private ButtonInterface buttonInterface;
	private FileManager FM;

	/**
	 * timer object that will check if the interface has changed every 100 seconds
	 */
	private Timer buttonListener;

	protected AudioObject[][] audioList;

	/**
	 * Takes in a buttonInterface and a Talkbox to use as aliases throughout the
	 * program
	 * 
	 * @param b
	 * @param tb
	 */
	public Device(ButtonInterface b, FileManager FM) {
		this.FM = FM;
		buttonInterface = b;
		setupAudio();
		initComponents();
	}

	/**
	 * initialized the components of this class
	 */
	private void initComponents() {
		buttonListener = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttonInterface.size(); i++) {
					Integer I = buttonInterface.get(i);
					if (I.equals(new Integer(1))) {
						playAudio(i);
						turnButtonOff(i);
					}
				}
			}
		});
		buttonListener.start();
	}

	/**
	 * Sets up the default audio when the program is first executed, should not be
	 * run unless the .tbc file is missing
	 */
	private void setupAudio() {
		String[][] audioNames = FM.getAudioFiles();
		audioList = new AudioObject[audioNames.length][audioNames[0].length];
		for (int i = 0; i < audioNames.length; i++) {
			for (int j = 0; j < audioNames[i].length; j++) {
				setAudio(i, j, audioNames[i][j]);

			}
		}
	}

	/**
	 * This sets the audio of a page randomly assigned
	 * 
	 * @param page
	 * @param index
	 * @param audioName
	 */
	private void setAudio(int page, int index, String audioName) {
		audioList[page][index] = new AudioObject(audioName, this.FM);
	}

	/**
	 * Turns a button on at index n
	 * 
	 * @param n
	 * @throws IndexOutOfBoundsException
	 */
	public void turnButtonON(int n) throws IndexOutOfBoundsException {
		if (n < 0 || n >= buttonInterface.size()) {
			throw new IndexOutOfBoundsException();
		}
		buttonInterface.turnOnButton(n);
	}

	/**
	 * turns a button off at index n
	 * 
	 * @param n
	 * @throws IndexOutOfBoundsException
	 */
	private void turnButtonOff(int n) throws IndexOutOfBoundsException {
		if (n < 0 || n >= buttonInterface.size()) {
			throw new IndexOutOfBoundsException();
		}
		buttonInterface.turnOffButton(n);
	}

	protected void playAudio(int index) {
		audioList[FM.getConfig().getSetNum()][index].playSound();
	}
}
