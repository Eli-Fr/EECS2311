package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class PanelBody extends JPanel implements ActionListener{
	
	private Configurator config;
	public static Log log  = LogFactory.getLog("logfile2");
	public final Dimension DIM;
	
	public PanelBody(VisualFrame owner){
		super();
		
		config = owner.getConfig();
		DIM = new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio());		
		
		this.setMinimumSize(DIM);
		this.setMaximumSize(DIM);
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());
		
		this.initBtn();
		
	}
	
	public void initBtn() {
		
		for(int i = 0; i < config.getNumberOfAudioButtons(); i++) {

				CustomBtn btn = new CustomBtn(config.getBtnName()[config.getSetNum()][i], (config.getRelativePathToImageFiles() +config.getImageFileNames()[config.getSetNum()][i]), i);
				btn.addActionListener(this);
				this.add(btn);
				this.revalidate();
				this.repaint();
				
			
		}	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().getClass().equals(Interface.CustomBtn.class)) {
		
			CustomBtn btn = (CustomBtn)e.getSource();
	
			String filePath = this.config.getRelativePathToAudioFiles() + this.config.getAudioFileNames()[config.getSetNum()][btn.getId()];
			
			try {
				AudioPlayer.player.start(new AudioStream(new FileInputStream(filePath)));
			    log.info("Click Audio button.");
			
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No Audio File Found for Button: " +btn.getText(), "Okay", JOptionPane.ERROR_MESSAGE);
				log.error(e1.getMessage());
			}
		}
		
	}
	

}
