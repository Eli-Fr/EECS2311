package Interface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

public class VisualFrame extends JFrame{
	
	private JPanel mainPanel;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private	Configurator config;
	
	public VisualFrame(String title) {
		
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			
			fis = new FileInputStream("TalkBoxData/Config.tbc");
			ois =  new ObjectInputStream(fis);
			
			config = (Configurator) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
