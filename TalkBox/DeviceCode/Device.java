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

	private Timer buttonListener;

	protected ArrayList<AudioSet> audioList = new ArrayList<AudioSet>();

	public Device(ButtonInterface b, TalkBox tb) {
		setup();
		setupDefaultAudio();
		buttonInterface = b;
		this.tb = tb;
		initComponents();
	}

	public void initComponents() {
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

	private void setupDefaultAudio() {
		audioList.add(new AudioSet());
		for (int i = 0; i < 6; i++) {
			setAudio(0, i, "Angry.wav");
		}
	}

	private void setAudio(int page, int index, String audioName) {
		audioList.get(page).setAudio(index,new AudioObject(audioName));
	}

	public void turnButtonON(int n) throws IndexOutOfBoundsException {
		if (n < 0 || n >= buttonInterface.size()) {
			throw new IndexOutOfBoundsException();
		}
		buttonInterface.turnOnButton(n);
	}

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
