package Talkbox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFrame;

public abstract class MainPanel extends JFrame implements fileManager, TalkBoxConfiguration {
	/**
	 * AUTO-GENERATED
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension DEFAULT_SCREEN_SIZE = new Dimension(1280, 720);
	public static final Dimension BUTTON_SIZE = new Dimension(150, 150);

	private Dimension currentScreenSize;
	protected ArrayList<ButtonSet> buttonList = new ArrayList<ButtonSet>();
	protected ArrayList<AudioSet> audioList = new ArrayList<AudioSet>();

	protected int currentPage = 0;
	protected int totalNumberOfButtons = 0;

	public MainPanel() {
		super();
		setup();
		getContentPane().setLayout(null);
		currentScreenSize = new Dimension((int) DEFAULT_SCREEN_SIZE.getWidth(), (int) DEFAULT_SCREEN_SIZE.getHeight());
		setSize(DEFAULT_SCREEN_SIZE);
		setResizable(false); // make this panel non resizable for now, TODO remove later
		// getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(150, 255, 150));// TODO set actual background color
	}

	protected void playAudio(int index) {
		audioList.get(currentPage).getAudio(index).playSound();
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

	private void setupDefaultButtons() {
		int listpos = 0;
		buttonList.add(new ButtonSet());
		ButtonSet alias = buttonList.get(0);
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		

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

		/**
		 * TODO change true condition when serialization is implemented
		 */
		if (true) {
			setupDefaultButtons();
		}
	}

	public int getCurrentHeight() {
		return (int) currentScreenSize.getHeight();

	}

	public int getCurrentWidth() {
		return (int) currentScreenSize.getWidth();

	}

	public Dimension getCurrentDimension() {
		return currentScreenSize;

	}

	public void setCurrentDimension(Dimension d) {
		this.currentScreenSize = d;

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
