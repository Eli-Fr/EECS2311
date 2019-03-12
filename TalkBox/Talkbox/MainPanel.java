package Talkbox;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;

public abstract class MainPanel extends JFrame implements {
	public static final Dimension DEFAULT_SCREEN_SIZE = new Dimension(1280, 720);
	private static final String WINDOWS_FILE_PATH = "C:\\TalkBox";

	public MainPanel() {
		super();
		setup();
		setSize(DEFAULT_SCREEN_SIZE);
		getContentPane().setLayout(null);
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
		for (File file : source.listFiles()) {
			File fileD = Paths.get(destination.getAbsolutePath() + "\\" + file.getName()).toFile();
			Files.createFile(fileD.toPath());
			FileChannel src = null;
			FileChannel dest = null;
			src = new FileInputStream(file).getChannel();
			dest = new FileOutputStream(fileD).getChannel();
			dest.transferFrom(src, 0, src.size());
			src.close();
			dest.close();
		}
	}

	/**
	 * This method only does something on the first execution of the talkbox on a
	 * new system
	 * 
	 * @pre fundamental system path does not exist
	 * @post fundamental system path is created
	 */
	private void setup() {
		if (!checkPath()) {
			createPath();
		}
	}
}
