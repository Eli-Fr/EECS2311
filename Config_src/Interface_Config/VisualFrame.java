package Interface_Config;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Helper_Methods.ShowError;
import Interface.Configurator;

import javax.swing.*;

public class VisualFrame extends JFrame {

	public PanelMain mainPanel;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private Configurator config;
	private File configFile;
	public File getConfigFile() {
		return configFile;
	}

	public static Log log = LogFactory.getLog("logfile1");

	public VisualFrame(String title, File configFile) {

		super(title);
		this.configFile = configFile;
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
			
				JOptionPane.showMessageDialog(null, "Press Ok to close window", "Okay", JOptionPane.OK_CANCEL_OPTION);
				log.info("Closed Configurator App");
				System.exit(0);
			
			}			
		});
		
		try {

			fis = new FileInputStream(this.configFile.getAbsoluteFile());
			ois = new ObjectInputStream(fis);

			config = (Configurator) ois.readObject();

		} catch (FileNotFoundException e) {

			log.error(e.getMessage());

			e.printStackTrace();

			ShowError.errorMessage("Cannot find TalkBoxData folder");

		} catch (IOException e) {

			log.error(e.getMessage());

			e.printStackTrace();

			ShowError.errorMessage("Cannot read " +this.configFile.toString());

		} catch (ClassNotFoundException e) {
			
			log.error(e.getMessage());
			
			e.printStackTrace();
			
			ShowError.errorMessage("File type is *.tbc");
		
		}

		this.setResizable(false);
		this.setSize(960 * config.getRatio(), 540 * config.getRatio());

		mainPanel = new PanelMain(this);

		this.setContentPane(mainPanel);
		this.setVisible(true);
	}

	public Configurator getConfig() {
		return this.config;
	}

}
