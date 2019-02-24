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

public class EditBtn extends JFrame implements ActionListener{
	
	JPanel main, name, image, audio, confirm;
	JButton imgBtn, audBtn, cancel, submit;
	JLabel imgPath, audPath;
	String imgFile, audFile, nameBtn, tempImg, tempAud;;
	JTextField nameText;
	
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
		
		JLabel title = new JLabel("Path: ");
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
		
		JLabel title = new JLabel("Path: ");
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
		cancel = new JButton("Cancel");
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
		
		confirm.add(submit);
		confirm.add(cancel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == this.submit) {
			
			this.nameBtn = this.nameText.getText();
			
			try {
			
				Files.copy(Paths.get(this.imgPath.getText()), Paths.get(this.imgFile, "/" ,this.tempImg), StandardCopyOption.REPLACE_EXISTING);
				Files.copy(Paths.get(this.audPath.getText()), Paths.get(this.audFile, "/" ,this.tempAud), StandardCopyOption.REPLACE_EXISTING);
			
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cannot find img or aud file", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cannot read img or aud file", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
			}
			
			this.imgFile = tempImg;
			this.audFile = tempAud;
			
			this.dispose();
			
		}
		else if(e.getSource() == this.cancel) {
			
			this.dispose();
			
		}
		else if(e.getSource() == this.imgBtn) {
			
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempImg = fd.getFile();
			System.out.println(tempImg);
			this.imgPath.setText(fd.getFiles()[0].getAbsolutePath());
			fd.dispose();
			
		}
		else if(e.getSource() == this.audBtn) {
			
			FileDialog fd = new FileDialog(new JFrame());
			fd.setVisible(true);
			tempAud = fd.getFile();
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

}
