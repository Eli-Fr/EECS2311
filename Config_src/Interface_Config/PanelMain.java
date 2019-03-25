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
import Interface.Configurator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PanelMain extends JPanel{
	
	public JPanel headingPane, preTextPane, bodyPane;
	public JScrollPane bodyPaneScroll;
	public JButton save;
	private Configurator config;
	public static Log log  = LogFactory.getLog("logfile1");
	
	public PanelMain(VisualFrame owner) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(211,211,211));
		
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
					JOptionPane.showMessageDialog(null, "Cannot find Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			        System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					log.error(e1.getMessage());
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot read Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			        System.exit(0);
				}
				
			}
		});
		
		
		
		bodyPaneScroll = new JScrollPane(bodyPane);
		bodyPaneScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bodyPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bodyPaneScroll.setMaximumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		bodyPaneScroll.setMinimumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		
		this.add(headingPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
		this.add(preTextPane);
		this.add(Box.createRigidArea(new Dimension(0,15 * owner.getConfig().getRatio())));
		this.add(bodyPaneScroll);
		this.add(save);
		
	}

}
