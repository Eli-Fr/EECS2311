package Device;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import Interface.Configurator;
import Interface.TalkBoxConfiguration;

/**
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 *
 */
public class FileManager {

//	public static final String WINDOWS_FILE_PATH = "C:\\TalkBox";
//	public static final String MACOS_FILE_PATH = "C:\\TalkBox";
//	public static final String LINUX_FILE_PATH = "C:\\TalkBox";

	private Configurator C;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private Configurator config;

	public FileManager(String S) {
		if (S == null) {
			setup("Default.tbc");
		} else {
			setup(S);
		}
	}

	public void setDefaults() {

	}

	/**
	 * 
	 * @param String to pointing to location of .tbc
	 */
	public void setup(String S) {
		try {

			fis = new FileInputStream("TalkBoxData" + System.getProperty("file.separator") + S);
			ois = new ObjectInputStream(fis);

			this.config = (Configurator) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot find TalkBoxData folder", "Confirm Exit",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "File type is *.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * Plays the audio of the currentpage at index
	 * 
	 * @param index
	 */

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

	public String[][] getAudioFiles() {
		return config.getAudioFileNames();
	}

	public String[][] getImageFiles() {
		return config.getImageFileNames();
	}

	public Configurator getConfig() {
		return this.config;
	}

}
