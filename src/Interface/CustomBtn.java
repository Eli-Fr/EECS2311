package Interface;

import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class CustomBtn extends JButton implements Serializable{

	private ImageIcon img;
	private String imgFileName;
	private byte[] wavFile;

	public CustomBtn(String name, String imgFileName, byte[] wavFile) throws Exception {
		super(name);
		
		System.out.println(imgFileName);
		
		this.setImg(imgFileName);
		
		this.setWavFile(wavFile);
		
		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);
		
	}
	
	public void setImg(String imgFileName) {
		this.imgFileName = imgFileName;
		try {
			this.img = new ImageIcon(ImageIO.read(new File(imgFileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setIcon(img);
	}
	
	public String getimgFileName() {
		return imgFileName;
	}
	

	public byte[] getWavFile() {
		return wavFile;
	}

	public void setWavFile(byte[] wavFile) {
		this.wavFile = wavFile;
	}


}
