package Interface_Config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;

import Interface.Configurator;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;


public class CustomBtn extends JButton{

	private ImageIcon img;
	public String imgFileName, wavFileName;
	private int id;
	public static Log log  = LogFactory.getLog(CustomBtn.class);
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
			
			BufferedImage buff = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
			Graphics2D G2D = buff.createGraphics();
			G2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			G2D.drawImage(this.img.getImage(), 0, 0, 100, 100, null);
			G2D.dispose();

			this.img = new ImageIcon(buff);
			
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
