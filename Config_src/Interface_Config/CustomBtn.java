package Interface_Config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;

import Interface.Configurator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class CustomBtn extends JButton{

	private ImageIcon img;
	private String imgFileName, wavFileName;
	private int id;
	public static Log log  = LogFactory.getLog("logfile1");
	public CustomBtn(String name, String imgFileName, int id, String wavFileName){
		super(name);
		
		this.setImg(imgFileName);
		this.wavFileName = wavFileName;
		
		this.setId(id);
		
		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);
		
	}
	
	public void setImg(String imgFileName) {
		this.imgFileName = imgFileName;
		try {
			this.img = new ImageIcon(ImageIO.read(new File(imgFileName)));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		this.setIcon(img);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getImgFileName() {
		return this.imgFileName;
	}
	
	public String getWavFileName() {
		return this.wavFileName;
	}

}
