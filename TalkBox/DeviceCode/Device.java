package DeviceCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.Timer;

import Interface.*;
import Talkbox.ButtonInterface;

/**
 * This class acts as the code that would be running on a physical raspberry PI
 * This includes: file Management, Serialization and Playing Audio
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 *
 */
public class Device implements TalkBoxConfiguration, fileManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of Aliases for the program to reference during calls
	 */
	private ButtonInterface buttonInterface;
	private TalkBox tb;

	/**
	 * timer object that will check if the interface has changed every 100 seconds
	 */
	private Timer buttonListener;

	protected ArrayList<AudioSet> audioList = new ArrayList<AudioSet>();

	/**
	 * Takes in a buttonInterface and a Talkbox to use as aliases throughout the
	 * program
	 * 
	 * @param b
	 * @param tb
	 */
	public Device(ButtonInterface b, TalkBox tb) {
		setup();
		setupDefaultAudio();
		buttonInterface = b;
		this.tb = tb;
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
	private void setupDefaultAudio() {
		audioList.add(new AudioSet());
		int listPos = 0;
		// page 0
		setAudio(0, listPos, "Angry.wav");
		setAudio(0, ++listPos, "Happy.wav");
		setAudio(0, ++listPos, "Sad.wav");
		setAudio(0, ++listPos, "Tired.wav");
		setAudio(0, ++listPos, "Hungry.wav");

		// page 1
		listPos = 0;
		setAudio(1, listPos, "Hello.wav");
		setAudio(1, ++listPos, "Goodbye.wav");
		setAudio(1, ++listPos, "Sleep.wav");
		setAudio(1, ++listPos, "Wash Room.wav");

	}

	/**
	 * This sets the audio of a page randomly assigned
	 * 
	 * @param page
	 * @param index
	 * @param audioName
	 */
	private void setAudio(int page, int index, String audioName) {
		@SuppressWarnings("unused")
		AudioSet alias = null;
		try {
			alias = audioList.get(page);
		} catch (Exception e) {
			audioList.add(new AudioSet());
		}
		audioList.get(page).setAudio(index, new AudioObject(audioName));
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

	/**
	 * This method only does something on the first execution of the talkbox on a
	 * new system
	 * 
	 * @pre no buttons are filled in the button setup
	 * @pre fundamental system path does not exist
	 * @post fundamental system path is created
	 * @post default button config established
	 */
	private void setup() {
		if (!checkPath()) {
			createPath();
		}
	}

	/**
	 * Plays the audio of the currentpage at index
	 * 
	 * @param index
	 */
	protected void playAudio(int index) {
		audioList.get(tb.getCurrentPage()).getAudio(index).playSound();
	}

	/**
	 * checks if system path exits
	 * 
	 * @return if the initial system path exists
	 */
	private boolean checkPath() {
		File Dir = new File("C:\\TalkBox");
		return Dir.isDirectory();
	}

	/**
	 * 
	 * Creates a new system path for the dependencies (specifically audio and image
	 * files)
	 *
	 */
	private void createPath() {
		try {
			Files.createDirectory(Paths.get("C:\\TalkBox"));
			Files.createDirectory(Paths.get("C:\\TalkBox\\TalkBoxData"));
			Files.createDirectory(Paths.get("C:\\TalkBox\\TalkBoxData\\Audio"));
			Files.createDirectory(Paths.get("C:\\TalkBox\\TalkBoxData\\Icon"));
			copyDir(Paths.get("TalkBoxData\\Icon").toFile(), new File("C:\\TalkBox\\TalkBoxData\\Icon"));
			copyDir(Paths.get("TalkBoxData\\Audio").toFile(), new File("C:\\TalkBox\\TalkBoxData\\Audio"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @pre source directory contains no sub directories
	 * @post destination directory is populated with sub directory files
	 * @param source      directory
	 * @param destination directory
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static void copyDir(File source, File destination) throws IOException {
		FileChannel src = null;
		FileChannel dest = null;
		for (File file : source.listFiles()) {
			File fileD = Paths.get(destination.getAbsolutePath() + "\\" + file.getName()).toFile();
			Files.createFile(fileD.toPath());

			src = new FileInputStream(file).getChannel();
			dest = new FileOutputStream(fileD).getChannel();
			dest.transferFrom(src, 0, src.size());
			src.close();
			dest.close();
		}
	}

	@Override
	public int getNumberOfAudioButtons() {
		int counter = 0;
		for (AudioSet AS : audioList) {
			counter += AS.size();
		}
		return counter;
	}

	@Override
	public int getNumberOfAudioSets() {
		return audioList.size();
	}

	@Override
	public int getTotalNumberOfButtons() {
		return 0;
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		return Paths.get("C:\\TalkBox\\Audio");
	}

	@Override
	public String[][] getAudioFileNames() {
		return null;
	}

}
