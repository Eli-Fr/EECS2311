package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PanelBody extends JPanel implements ActionListener{
	
	private Configurator config;
	private JPanel setPanel;
	private JScrollPane setScroll;

	public PanelBody(VisualFrame owner){
		super();
		
		config = owner.getConfig();
		
		this.setMinimumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());
		
		this.initSet();
		
		setScroll = new JScrollPane(setPanel);
		setScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setScroll.setMaximumSize(new Dimension(150 * owner.getConfig().getRatio(), this.getHeight()));
		setScroll.setMinimumSize(new Dimension(150 * owner.getConfig().getRatio(), this.getHeight()));
		
		this.add(setScroll);
		this.initBtn();
		
	}
	
	public void initBtn() {
		
		for(int i = 0; i < config.getNumberOfAudioButtons(); i++) {
			
			try {
				
				CustomBtn btn = new CustomBtn(config.getBtnName()[config.getSetNum()][i], (config.getRelativePathToImageFiles() +config.getImageFileNames()[config.getSetNum()][i]), i);
				btn.addActionListener(this);
				this.add(btn);
				this.revalidate();
				this.repaint();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cannot read Config.tbc", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
			}
			
		}	
	}
	
	public void initSet() {
		
		setPanel = new JPanel();
		setPanel.setMinimumSize(new Dimension(150 * config.getRatio(), this.getHeight()));
		setPanel.setMaximumSize(new Dimension(150 * config.getRatio(), this.getHeight()));
		setPanel.setBackground(new Color(0, 12, 25));
		
		setPanel.setLayout(new BoxLayout(setPanel, BoxLayout.Y_AXIS));
		
		JLabel setTitle = new JLabel("Audio Set", SwingConstants.CENTER);
		setTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		setTitle.setForeground(Color.WHITE);
		
		setPanel.add(setTitle);
		
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			
			JButton btn = new JButton(config.getSetBtn()[i]);
			btn.addActionListener(this);
			setPanel.add(btn);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().getClass().equals(Interface.CustomBtn.class)) {
		
			CustomBtn btn = (CustomBtn)e.getSource();
	
			String filePath = this.config.getRelativePathToAudioFiles() + this.config.getAudioFileNames()[config.getSetNum()][btn.getId()];
			
			try {
				
				AudioPlayer.player.start(new AudioStream(new FileInputStream(filePath)));
			
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No Audio File Found for Button: " +btn.getText(), "Confirm Exit", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
			}
		}
		else {
			
			config.setSetNum(Arrays.asList(config.getSetBtn()).indexOf(((JButton)e.getSource()).getText()));
			
			for(int i = config.getNumberOfAudioButtons(); i > 0; i--) {
				this.remove(i);
			}
			
			this.config.setNumberOfAudioButtons(config.getBtnName()[config.getSetNum()].length); 
			this.initBtn();
		}
		
	}
	

}
