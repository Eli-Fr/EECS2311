package Interface;

import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import Helper_Methods.ShowError;

public class CustomBtn extends JButton{

	private ImageIcon img;
	private String imgFileName;
	private int id;
	public static Log log  = LogFactory.getLog("logfile2");
	public CustomBtn(String name, String imgFileName, int id){
		super(name);
		
		this.setImg(imgFileName);
		
		this.setId(id);
		
		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);
		
	}
	
	public void setImg(String imgFileName) {
		this.imgFileName = imgFileName;
		try {
			this.img = new ImageIcon(ImageIO.read(new File(imgFileName)));
		} catch (IOException e) {
			ShowError.errorMessageOK("No Image File Found for Button: " +this.getText());
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

}
