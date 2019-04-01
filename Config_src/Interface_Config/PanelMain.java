package Interface_Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Helper_Methods.ShowError;
import Interface.Configurator;

public class PanelMain extends JPanel{
	
	public JPanel headingPane, preTextPane;
	public PanelBody bodyPane;
	public JScrollPane bodyPaneScroll;
	public JButton save;
	private Configurator config;
	public static Log log  = LogFactory.getLog("logfile1");
	
	public PanelMain(VisualFrame owner) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(5, 19, 54));
		
		headingPane = new PanelHeading(owner);
		preTextPane = new PanelPreText(owner);
		bodyPane = new PanelBody(owner);
		save = new JButton("Save");
		
		save.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				config = ((PanelBody) bodyPane).getConfig();
				config.setRatio(((PanelPreText) preTextPane).getRatio());
				try {
					
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TalkBoxData/Config.tbc")));
					oos.writeObject(config);
					
					log.info("Change saved");
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					log.error(e1.getMessage());
					
					e1.printStackTrace();
					
					ShowError.errorMessage("Cannot find Config.tbc");
			        System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					log.error(e1.getMessage());
					
					e1.printStackTrace();
					
					ShowError.errorMessage("Cannot read Config.tbc");
			        System.exit(0);
				}
				
			}
		});
		
		
		
		bodyPaneScroll = new JScrollPane(bodyPane);
		bodyPaneScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bodyPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(headingPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
		this.add(preTextPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
		this.add(bodyPaneScroll);
		this.add(save);
		
	}

}
