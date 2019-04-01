package Interface_Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.*;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Interface.Configurator;

public class PanelBody extends JPanel implements ActionListener{
	
	private Configurator config;
	public ArrayList<String> btnName;
	public ArrayList<String> imgPath;
	public ArrayList<String> audPath;
	public String[][] nameArr;
	public String[][] imgArr;
	public String[][] audArr;
	public static Log log  = LogFactory.getLog("logfile1");

	public PanelBody(VisualFrame owner){
		super();
		
		config = owner.getConfig();
		
		arrSet();
		
		this.setMinimumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth()+15, 175 * owner.getConfig().getRatio()));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new FlowLayout());
		
		this.initBtn();
		
	}
	
	public void arrSet() {
		
		nameArr = config.getBtnName();
		imgArr = config.getImageFileNames();
		audArr = config.getAudioFileNames();
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
	
	public void actionPerformed(ActionEvent e) {
		
			CustomBtn btn = (CustomBtn)e.getSource();
	
			if(btn.getId() == config.getNumberOfAudioButtons()) {
				
				config.setNumberOfAudioButtons(config.getNumberOfAudioButtons()+1);
				btnName.add("Edit");
				imgPath.add("/Edit.jpg");
				audPath.add("Nothing");
				
				ChangeBtn(0);
				log.info("Add Audio button.");
			}
			else {
				EditBtn edit = new EditBtn(btn.getText(), config.getRelativePathToImageFiles().toString(), this.config.getRelativePathToAudioFiles().toString());
				log.info("Edit Audio button.");
				edit.addWindowListener(new WindowAdapter() {
				
					@Override
					public void windowClosed(WindowEvent e) {
						btnName.set(btn.getId(), edit.getName());
						if(edit.getImgChange())		imgPath.set(btn.getId(), edit.getImgFile());
						if(edit.getAudChange())		audPath.set(btn.getId(), edit.getAudFile());
						
						ChangeBtn(1);
						log.info("Add/Edit your button windows closed");
						
					}
				});
			}
		
	}

	private void ChangeBtn(int offSet) {
		// TODO Auto-generated method stub
		
		for(int i = config.getNumberOfAudioButtons() + (offSet-1); i >= 0; i--) {
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
