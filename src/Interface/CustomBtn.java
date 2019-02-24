package Interface;

import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class CustomBtn extends JButton{

	private ImageIcon img;
	private String imgFileName;
	private int id;

	public CustomBtn(String name, String imgFileName, int id) throws Exception {
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
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No Image for " + this.getText() , "Confirm Exit", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
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
