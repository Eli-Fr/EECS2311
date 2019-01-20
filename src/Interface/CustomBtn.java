package Interface;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CustomBtn extends JButton{

	public ImageIcon img;
	
	public CustomBtn(String name) {
		super(name);
		
		try {
			img = new ImageIcon(ImageIO.read(new File("src/Interface/" +name +".jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setIcon(img);
		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);
		
	}
}
