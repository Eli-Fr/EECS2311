package Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

public class VisualFrame extends JFrame {

	private JPanel mainPanel;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private Configurator config;

	public VisualFrame(String title) {

		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {

			fis = new FileInputStream("TalkBoxData/Config.tbc");
			ois = new ObjectInputStream(fis);

			config = (Configurator) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot find TalkBoxData folder", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
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

		this.setResizable(false);
		this.setSize(720 * config.getRatio(), 480 * config.getRatio());

		mainPanel = new PanelMain(this);

		this.setContentPane(mainPanel);
		this.setVisible(true);
	}

	public Configurator getConfig() {
		return this.config;
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
	 * Creates a new system path for the dependencies (specifically audio and
	 * image files)
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
	 * @param source
	 *            directory
	 * @param destination
	 *            directory
	 * @throws IOException
	 */
	private static void copyDir(File source, File destination) throws IOException {
		System.out.println(source.listFiles().toString());
		for (File file : source.listFiles()) {
			File fileD = Paths.get(destination.getAbsolutePath() + "\\" + file.getName()).toFile();
			System.out.println(fileD.getAbsolutePath());
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
	 * This method only does something on the first execution of the talkbox on
	 * a new system
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
