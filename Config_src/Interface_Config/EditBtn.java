package Interface_Config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import javax.swing.*;

import Interface.Configurator;
import Recording.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EditBtn extends JFrame implements ActionListener{
	
	JPanel main, name, image, audio, confirm, recDND;
	public JButton imgBtn, audBtn, cancel, submit, delete, record;
	RecorderFrame recFrame;
	PanelBody pb;
	
	JLabel imgPath, audPath, dragNdrop;	
	JTextField nameText;
	CustomBtn previewBtn;	

	String imgFile, audFile, nameBtn, tempImg, tempAud;
	public boolean imgChanged, audChanged, isDeleted;
	public static Log log  = LogFactory.getLog("logfile1");
	public int check = 0;
	
	public EditBtn(String name, PanelBody pb) {
		
		super("Add/Edit your Button");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pb = pb;
		
		this.setResizable(false);
		
		this.initMain();
		this.nameText.setText(name);
		this.imgPath.setText(pb.getConfig().getRelativePathToImageFiles().toString());
		this.audPath.setText(pb.getConfig().getRelativePathToAudioFiles().toString());
		
		this.nameBtn = name;
		this.imgFile = imgPath.getText();
		this.audFile = audPath.getText();
		
		this.imgChanged = false;
		this.audChanged = false;
		
		this.setSize(600, 375);
		this.setContentPane(main);
		this.setVisible(true);
		
		int index = (Arrays.asList((pb.getConfig().getBtnName()[pb.getConfig().getSetNum()])).indexOf(this.nameBtn));
		
		previewBtn = new CustomBtn(this.nameBtn, pb.getConfig().getRelativePathToImageFiles().toString() + pb.getConfig().getImageFileNames()[pb.getConfig().getSetNum()][index], 0, pb.getConfig().getRelativePathToAudioFiles().toString() + pb.getConfig().getAudioFileNames()[pb.getConfig().getSetNum()][index]);
		previewBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println(previewBtn.wavFileName);
					AudioPlayer.player.start(new AudioStream(new FileInputStream(previewBtn.getWavFileName())));
				    log.info("Click Audio button.");
				
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No Audio File Found for Button: " +name, "Okay", JOptionPane.ERROR_MESSAGE);
					log.error(e1.getMessage());
				}
				
			}
		});
		main.add(previewBtn, SwingConstants.CENTER);
		
	}
	
	public void initMain() {
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		this.initName();
		this.initImage();
		this.initAudio();
		this.initRecDND();
		this.initConfirm();
		
		main.add(name);
		main.add(image);
		main.add(audio);
		main.add(recDND);
		main.add(confirm);
		
	}
	
	public void initName() {
		name = new JPanel();
		name.setLayout(new FlowLayout());
		
		JLabel title = new JLabel("Name: ");
		nameText = new JTextField();
		
		name.add(title);
		name.add(nameText);
	}
	
	public void initImage() {
		
		image = new JPanel();
		image.setLayout(new FlowLayout());
		
		JLabel title = new JLabel("Image Path: ");
		imgPath = new JLabel("N/A");
		imgBtn = new JButton("Browse");
		
		imgBtn.addActionListener(this);
		
		image.add(title);
		image.add(imgPath);
		image.add(imgBtn);
		
	}
	
	public void initAudio() {
		
		audio = new JPanel();
		audio.setLayout(new FlowLayout());
		
		JLabel title = new JLabel("Audio Path: ");
		audPath = new JLabel("N/A");
		audBtn = new JButton("Browse");
		audBtn.addActionListener(this);
		
		audio.add(title);
		audio.add(audPath);
		audio.add(audBtn);
		
	}
	
	public void initRecDND() {
		
		recDND = new JPanel();
		recDND.setLayout(new FlowLayout());
		record = new JButton("Record");
		dragNdrop = new DragNDropLabel(this);
		
		dragNdrop.setPreferredSize(new Dimension(150, 100));
		dragNdrop.setBackground(Color.gray);
		dragNdrop.setOpaque(true);
		dragNdrop.setHorizontalAlignment(JLabel.CENTER);
		dragNdrop.setVerticalAlignment(JLabel.CENTER);
		
		record.addActionListener(this);
		
		recDND.add(record);
		recDND.add(dragNdrop);
		
	}
	
	public void initConfirm() {
		
		confirm = new JPanel();
		confirm.setLayout(new FlowLayout());
		
		submit = new JButton("Submit");
		delete = new JButton("Delete");
		cancel = new JButton("Cancel");
		
		submit.addActionListener(this);
		delete.addActionListener(this);
		cancel.addActionListener(this);
		
		confirm.add(submit);
		confirm.add(delete);
		confirm.add(cancel);
		
	}
	
	public String getName() {
		return this.nameBtn;
	}
	
	public String getImgFile() {
		return "/" +this.imgFile;
	}
	
	public String getAudFile() {
		return "/" +this.audFile;
	}
	
	public boolean getImgChange() {
		return this.imgChanged;
	}
	
	public boolean getAudChange() {
		return this.audChanged;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == this.submit) {
			check = 1;
			this.submit();
			
		}
		
		else if(e.getSource() == this.cancel) {
			check = 2;
			this.dispose();
			log.info("Cancel change");
		}
		
		else if(e.getSource() == this.imgBtn) {
			check = 3;
			log.info("Image browse clicked");
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempImg = fd.getFile();
			
			this.imgBtn(fd.getFiles()[0].getAbsolutePath());
			
			fd.dispose();
			
		}
		else if(e.getSource() == this.audBtn) {
			check = 4;
			log.info("Audio browse clicked");
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempAud = fd.getFile();
			
			this.audBtn(fd.getFiles()[0].getAbsolutePath());
			
			fd.dispose();
			
		}
		
		else if(e.getSource() == this.delete) {
			check = 5;
			this.deletePrompt();
			
		}
		
		else if(e.getSource() == this.record) {
			log.info("Click Record Button");
			check = 6;
			recFrame = new RecorderFrame();
			recFrame.addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosed(WindowEvent e) {
					
					if(recFrame.useRec) {
						
						String temp = nameBtn + ".wav";
						int i = 1;
						while((new File("TalkBoxData/Audio/" +temp)).exists()) {
							temp = nameBtn +i +".wav";
						}
						tempAud = temp;
						audBtn(recFrame.getfName());
					}
					
				}
				
			});
			
		}
		
	}
	
	public void submit() {
		
		this.nameBtn = this.nameText.getText();
		log.info("Click Sumbit Button");
		try {
		
			if(this.imgChanged) {
				Files.copy(Paths.get(this.imgPath.getText()), Paths.get(this.imgFile, "/" ,this.tempImg), StandardCopyOption.REPLACE_EXISTING);
				this.imgFile = tempImg;
				log.info("Changed image");
				check = 7;
			}
			
			if(this.audChanged) {
				Files.copy(Paths.get(this.audPath.getText()), Paths.get(this.audFile, "/" ,this.tempAud), StandardCopyOption.REPLACE_EXISTING);
				this.audFile = tempAud;
				System.out.println("The audio file is " +this.audFile);
				log.info("Changed audio");
				check = 8;
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			log.error(e1.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
			log.error(e1.getMessage());
		}
		
		this.dispose();
		
		
	}
	
	public void imgBtn(String path) {
		
		if(tempImg.endsWith(".jpg")||tempImg.endsWith(".png")) {
			this.imgChanged = true;
			this.imgPath.setText(path);
			this.previewBtn.setImg(this.imgPath.getText());
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong image file format. Correct is .jpg or .png extension.", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error("Wrong image file format.");
		}
		
	}
	
	public void audBtn(String path) {
		System.out.println(path.toString());
		
		if(tempAud.endsWith(".wav")) {
			this.audChanged = true;
			this.audPath.setText(path);
			this.previewBtn.wavFileName = this.audPath.getText();
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong audio file format. Correct is .wav extension.", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error("Wrong audio file format.");
		}
		
	}
	
	public void deletePrompt() {
		
		int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(response == JOptionPane.YES_OPTION) {
			this.isDeleted = true;
			this.dispose();
		}
		
	}
	

}
