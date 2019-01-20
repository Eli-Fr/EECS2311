package Interface;
import DeviceSpeaker.*;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomBtn extends JButton{

	public ImageIcon img;
	
	public CustomBtn(String name, SpeakerClass sc) {
		super(name);
		
		try {
			img = new ImageIcon(ImageIO.read(new File("src/Interface/" +name +".jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setIcon(img);
		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.say(name);				
			}
		});
		
	}

}
