package Main;


import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Device.ButtonInterface;
import Device.Device;
import Device.FileManager;
import Interface.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class TalkBoxSimulator {

	/**
	 * List of Constants for the program
	 */
	public static final int MAX_NUMBER_OF_BUTTONS_PER_PAGE = 8;

	/**
	 * List of objects
	 */
	public static TalkBoxUI simulator;
	public static Device D;
	public static FileManager FM;
	public static ButtonInterface BI;
	public static Log log  = LogFactory.getLog("logfile2");
	
	public static void main(String[] args) {

		// TODO: Add a prompt for the user to select between a default TB or use a cfg

		JFrame choser = new JFrame("Choose");
		choser.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton choose = new JButton("Load a File");
		JButton def = new JButton("Default File");
		
		choser.add(choose);
		choser.add(def);
		
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog fd = new FileDialog(new JFrame());
				fd.setVisible(true);
				String file = fd.getFile().toString();
				
				if(file.endsWith(".tbc")) {
					log.info("Loading selected *.tbc");
					fd.dispose();
					init(file);
					
					choser.dispose();
					return;
				}
				
				JOptionPane.showMessageDialog(choser, "Choose a file with extension *.tbc");
				log.error("Choose a file with extension *.tbc");
			}
		});
		
		def.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				log.info("Loading Default.tbc");
				init(null);
				choser.dispose();
			}
		});
		
		choser.pack();
		choser.setVisible(true);

	}
	
	public static void init(String s) {
		
	// TODO: change null to config file name
			FM = new FileManager(s);
			log.info("Simulator starting");
			BI = new ButtonInterface();
			simulator = new TalkBoxUI("TalkBotSimulator", FM.getConfig(), BI);
			D = new Device(BI, FM);
		
	}

}
