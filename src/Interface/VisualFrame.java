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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import javax.swing.*;

public class VisualFrame extends JFrame {

	public PanelMain mainPanel;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private Configurator config;
	public static Log log  = LogFactory.getLog("logfile2");

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
			log.error(e.getMessage());
	        
		} catch (IOException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Cannot read Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "File type is *.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
	        
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
