package Interface;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import DeviceCode.fileManager;

public class InterfaceButton extends JButton {

	private ImageIcon image;
	private int listPos;
	private String name, imageName;

	private MainPanel owner;

	public InterfaceButton(int listPos, MainPanel owner, String name, String imageName) {
		super(name);
		this.listPos = listPos;
		this.owner = owner;
		this.name = name;
		this.imageName = imageName;
		this.setImage(imageName);
		this.setBounds(250+100*listPos, 360-image.getIconHeight()/2, image.getIconWidth(), image.getIconHeight() + 30);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		System.out.println(this.getSize());
		this.setBackground(Color.cyan);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFocusPainted(false);
		this.setFocusable(false);
		owner.getContentPane().add(this);
	}

	/**
	 * Sets the buttons image based on file name inputted
	 * @param imageName
	 */
	public void setImage(String imageName) {
		try {
			this.image = new ImageIcon(
					ImageIO.read(new File(fileManager.WINDOWS_FILE_PATH + "\\TalkBoxData\\Icon\\" + imageName)));
		} catch (IOException e) {
			System.out.println("no image found");
		}
		this.setIcon(image);
	}
	
	public int getID() {
		return this.listPos;
	}

}
