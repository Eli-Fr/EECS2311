package Interface_Config;

import Interface.Configurator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.*;
import java.util.*;

public class PanelBody extends JPanel implements ActionListener{
	
	private Configurator config;
	private JPanel setPanel;
	private JScrollPane setScroll;
	private ArrayList<String> btnName;
	private ArrayList<String> imgPath;
	private ArrayList<String> audPath;
	private String[][] nameArr;
	private String[][] imgArr;
	private String[][] audArr;

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
		
		btnName = new ArrayList<String>(Arrays.asList(config.getBtnName()[config.getSetNum()]));
		imgPath = new ArrayList<String>(Arrays.asList(config.getImageFileNames()[config.getSetNum()]));
		audPath = new ArrayList<String>(Arrays.asList(config.getAudioFileNames()[config.getSetNum()]));
		
		for(int i = 0; i < config.getNumberOfAudioButtons(); i++) {
		
			CustomBtn btn = new CustomBtn(config.getBtnName()[config.getSetNum()][i], (config.getRelativePathToImageFiles() +"/Edit.jpg"), i, this.config.getRelativePathToAudioFiles() + this.config.getAudioFileNames()[config.getSetNum()][i]);
				btn.addActionListener(this);
				btn.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                if (SwingUtilities.isRightMouseButton(e)) {
		                    btnName.remove(btn.getId());
		                    imgPath.remove(btn.getId());
		                    audPath.remove(btn.getId());
		                    
		                    config.setNumberOfAudioButtons(config.getNumberOfAudioButtons()-1);
		                    
		                    ChangeBtn(2);
		                }
		            }
		        });
				this.add(btn);
				this.revalidate();
				this.repaint();
			
		}
		
		CustomBtn btn = new CustomBtn("Add", (config.getRelativePathToImageFiles() +"/Add.jpg"), config.getNumberOfAudioButtons(), "Nothing");
		btn.addActionListener(this);		
		this.add(btn);
		this.revalidate();
		this.repaint();
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
		
		nameArr = config.getBtnName();
		imgArr = config.getImageFileNames();
		audArr = config.getAudioFileNames();
				
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			
			JButton btn = new JButton(config.getSetBtn()[i]);
			btn.addActionListener(this);
			setPanel.add(btn);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().getClass().equals(Interface_Config.CustomBtn.class)) {
		
			CustomBtn btn = (CustomBtn)e.getSource();
	
			if(btn.getId() == config.getNumberOfAudioButtons()) {
				
				config.setNumberOfAudioButtons(config.getNumberOfAudioButtons()+1);
				btnName.add("Edit");
				imgPath.add("/Edit.jpg");
				audPath.add("Nothing");
				
				ChangeBtn(0);
				
			}
			else {
				EditBtn edit = new EditBtn(btn.getText(), config.getRelativePathToImageFiles().toString(), this.config.getRelativePathToAudioFiles().toString());
				
				edit.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						btnName.set(btn.getId(), edit.getName());
						if(edit.getImgChange())		imgPath.set(btn.getId(), edit.getImgFile());
						if(edit.getAudChange())		audPath.set(btn.getId(), edit.getAudFile());
						
						ChangeBtn(1);
						
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			
			
		}
		else {
			
			config.setSetNum(Arrays.asList(config.getSetBtn()).indexOf(((JButton)e.getSource()).getText()));
			
			for(int i = config.getNumberOfAudioButtons() + 1; i > 0; i--) {
				this.remove(i);
			}
			
			config.setNumberOfAudioButtons(config.getBtnName()[config.getSetNum()].length);
			
			this.initBtn();
		}
		
	}

	private void ChangeBtn(int offSet) {
		// TODO Auto-generated method stub
		
		for(int i = config.getNumberOfAudioButtons() + offSet; i > 0; i--) {
			this.remove(i);
		}
		
		String[] temp = new String[btnName.size()];
		String[] temp2 = new String[imgPath.size()];
		String[] temp3 = new String[audPath.size()];
		
		btnName.toArray(temp);
		imgPath.toArray(temp2);
		audPath.toArray(temp3);
		 
		nameArr[config.getSetNum()] = temp;
		imgArr[config.getSetNum()] = temp2;
		audArr[config.getSetNum()] = temp3;
		
		config.setBtnName(nameArr);
		config.setImageFileNames(imgArr);
		config.setAudioFileNames(audArr);
		
		this.initBtn();
		
	}
	

	public Configurator getConfig() {
		return this.config;
	}

}
