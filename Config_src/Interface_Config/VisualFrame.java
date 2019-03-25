package Interface_Config;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import Interface.Configurator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;

public class VisualFrame extends JFrame{
	
	private JPanel mainPanel;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private	Configurator config;
	public static Log log  = LogFactory.getLog("logfile1");
	
	public VisualFrame(String title) {
		
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Press Ok to close window", "Okay", JOptionPane.OK_CANCEL_OPTION);
				log.info("Closed Configurator App");
				System.exit(0);
			}
		});	
		try {
			
			fis = new FileInputStream("TalkBoxData/Config.tbc");
			ois =  new ObjectInputStream(fis);
			
			config = (Configurator) ois.readObject();
			
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot find TalkBoxData folder", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
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
	
}
