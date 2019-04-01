package TBC_Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import Helper_Methods.ShowError;



import javax.swing.*;

import Interface.Configurator;

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
			ShowError.errorMessage("Cannot find TalkBoxData folder");
	        System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			ShowError.errorMessage("Cannot read Config.tbc");
	        System.exit(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ShowError.errorMessage("File type is *.tbc");
	        System.exit(0);
		}
		this.setResizable(false);
		this.setSize(1280 * config.getRatio(), 720 * config.getRatio());

		mainPanel = new PanelMain(this);

		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
	
	public Configurator getConfig() {
		return this.config;
	}


}
