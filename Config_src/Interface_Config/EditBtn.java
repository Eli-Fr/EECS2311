package Interface_Config;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.*;

import Interface.Configurator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EditBtn extends JFrame implements ActionListener{
	
	JPanel main, name, image, audio, confirm;
	JButton imgBtn, audBtn, cancel, submit, delete;
	JLabel imgPath, audPath;
	String imgFile, audFile, nameBtn, tempImg, tempAud;;
	JTextField nameText;
	boolean imgChanged, audChanged;
	public static Log log  = LogFactory.getLog("logfile1");
	public EditBtn(String name, String imgPath, String audPath) {
		
		super("Add/Edit your Button");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setResizable(false);
		
		this.initMain();
		this.nameText.setText(name);
		this.imgPath.setText(imgPath);
		this.audPath.setText(audPath);
		
		this.nameBtn = name;
		this.imgFile = imgPath;
		this.audFile = audPath;
		
		this.imgChanged = false;
		this.audChanged = false;
		
		this.setSize(600, 275);
		this.setContentPane(main);
		this.setVisible(true);
		
	}
	
	public void initMain() {
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		this.initName();
		this.initImage();
		this.initAudio();
		this.initConfirm();
		
		main.add(name);
		main.add(image);
		main.add(audio);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == this.submit) {
			
			this.nameBtn = this.nameText.getText();
			
			try {
			
				if(this.imgChanged) {
					Files.copy(Paths.get(this.imgPath.getText()), Paths.get(this.imgFile, "/" ,this.tempImg), StandardCopyOption.REPLACE_EXISTING);
					this.imgFile = tempImg;
					log.info("Changed image");
				}
				
				if(this.audChanged) {
					Files.copy(Paths.get(this.audPath.getText()), Paths.get(this.audFile, "/" ,this.tempAud), StandardCopyOption.REPLACE_EXISTING);
					this.audFile = tempAud;
					log.info("Changed audio");
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
		else if(e.getSource() == this.cancel) {
			
			this.dispose();
			log.info("Cancel change");
		}
		else if(e.getSource() == this.imgBtn) {
			log.info("Image browse clicked");
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempImg = fd.getFile();
			if(tempImg.endsWith(".jpg")||tempImg.endsWith(".png")) {
				this.imgChanged = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong image file format. Correct is .jpg or .png extension.", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
				log.error("Wrong image file format.");
			}
			this.imgPath.setText(fd.getFiles()[0].getAbsolutePath());
			fd.dispose();
			
		}
		else if(e.getSource() == this.audBtn) {
			log.info("Audio browse clicked");
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempAud = fd.getFile();
			if(tempAud.endsWith(".wav")) {
				this.audChanged = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong audio file format. Correct is .wav extension.", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
				log.error("Wrong audio file format.");
			}
			System.out.println(tempAud);
			this.audPath.setText(fd.getFiles()[0].getAbsolutePath());
			fd.dispose();
			
		}
		
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

}
