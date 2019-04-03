import Interface_Config.*;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TalkBotConfigurator {
	public static Log log  = LogFactory.getLog("logfile1");
	
	public static void main(String[] args) throws Exception{
		
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
				File file = fd.getFiles()[0];
				
				if(file.toString().endsWith(".tbc")) {
					log.info("Loading selected *.tbc");
					fd.dispose();
					init(file);
					
					choser.dispose();
					return;
				}
				log.error("Choose a file with extension *.tbc");
				JOptionPane.showMessageDialog(choser, "Choose a file with extension *.tbc");
				
			}
		});
		
		def.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Loading Default.tbc");
				// TODO Auto-generated method stub
				init(new File("TalkBoxData/Default.tbc"));
				choser.dispose();
			}
		});
		
		choser.pack();
		choser.setVisible(true);
		
	}
	
	public static void init(File cf) {
		
		log.info("Start Configurator");
		VisualFrame Configurator = new VisualFrame("TalkBotConfigurator", cf);
		
	}

}