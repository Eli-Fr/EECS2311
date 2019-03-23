package Interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import DeviceCode.fileManager;

public class InterfaceButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	private int listPos;
	private String name, imageName;

	private MainPanel owner;

	public InterfaceButton(int listPos, MainPanel owner, String name, String imageName) {
		super(name);
		this.listPos = listPos;
		this.addActionListener(this);
		this.owner = owner;
		this.name = name;
		this.setImageName(imageName);
		owner.add(this);
		this.setImage(imageName);
		this.setBounds(250 + 100 * listPos, middleY(),
				image.getIconWidth(), image.getIconHeight() + 30);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		this.setBackground(Color.cyan);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFocusPainted(false);
		this.setFocusable(false);

	}

	/**
	 * Sets the buttons image based on file name inputted
	 * 
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

	public void actionPerformed(ActionEvent e) {
		System.out.println("Action Event");
		// if the actionEvent is a button press
		if (e.getSource().getClass() == InterfaceButton.class) {
			InterfaceButton ib = (InterfaceButton) e.getSource();
			owner.turnButtonON(ib.getID() % 6);
			System.out.println("button pressed");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public int middleY() {
		return  this.owner.getHeight() / 2 - image.getIconHeight();
	}

}
