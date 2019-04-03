package Interface_Config;


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

import Interface.Configurator;

public class PanelAudioSet extends JPanel implements ActionListener{

	public JScrollPane setScroll;
	private Configurator config;
	private VisualFrame owner;
	
	public PanelAudioSet(VisualFrame owner) {
		
		this.owner = owner;
		this.config = owner.getConfig();
		
		setScroll = new JScrollPane(this);
		setScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		setScroll.setMinimumSize(new Dimension(owner.getWidth(), 50 * owner.getConfig().getRatio()));
		setScroll.setMaximumSize(new Dimension(owner.getWidth(), 50 * owner.getConfig().getRatio()));
		
		
		this.initSet();
		
	}
	
	public void initSet() {
			
		this.setBackground(new Color(0, 12, 25));
		
		this.setLayout(new FlowLayout());
		
		JLabel setTitle = new JLabel("Audio Set", SwingConstants.CENTER);
		setTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		setTitle.setForeground(Color.WHITE);
		
		this.add(setTitle);
		
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			
			JButton btn = new JButton(config.getSetBtn()[i]);
			btn.addActionListener(this);
			this.add(btn);
		}
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		config.setSetNum(Arrays.asList(config.getSetBtn()).indexOf(((JButton)e.getSource()).getText()));
		
		for(int i = config.getNumberOfAudioButtons(); i >= 0; i--) {
			owner.mainPanel.bodyPane.remove(i);
		}
		
		config.setNumberOfAudioButtons(config.getBtnName()[config.getSetNum()].length);
		
		owner.mainPanel.bodyPane.initBtn();
		owner.mainPanel.bodyPane.log.info("Change audio set");
		
	}
	
}
