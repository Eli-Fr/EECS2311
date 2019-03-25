package Config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
		this.setBounds(0, middleY(), 100, 100 + 30);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setBackground(Color.white);
	}

	public InterfaceButton(InterfaceButton other, MainPanel p) {
		super(other.name);
		this.name = other.name;
		this.owner = p;
		p.add(this);
		this.setImage(other.imageName);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.BOTTOM);
	}

	public void resizeButton(int width, int height) {
		this.setSize(new Dimension(width, height + 30));
		scaleImage(image, width, height);
		this.setIcon(image);
	}

	private void scaleImage(ImageIcon input, int width, int height) {
		BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D G2D = buff.createGraphics();
		G2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		G2D.drawImage(input.getImage(), 0, 0, width, height, null);
		G2D.dispose();

		image = new ImageIcon(buff);

	}

	/**
	 * Sets the buttons image based on file name inputted
	 * 
	 * @param imageName
	 */
	public void setImage(String imageName) {
		if (imageName == null) {

		} else {
			try {
				this.image = new ImageIcon(
						ImageIO.read(new File(fileManager.WINDOWS_FILE_PATH + "\\TalkBoxData\\Icon\\" + imageName)));
			} catch (IOException e) {
				System.out.println("no image found");
			}
			scaleImage(image, 100, 100);
			this.setIcon(image);
		}
	}

	public int getID() {
		return this.listPos;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Action Event");
		// if the actionEvent is a button press
		if (e.getSource().getClass() == InterfaceButton.class) {
			InterfaceButton ib = (InterfaceButton) e.getSource();
			if (ib.listPos < 0) {
				if (name.equals("LEFT")) {
					owner.LoadSet(owner.getCurrentPage() - 1);
				} else if (name.equals("RIGHT")) {
					owner.LoadSet(owner.getCurrentPage() + 1);
				}
			} else {
				owner.openConfig(this);

			}
		}
	}

	public void setPosition(int x, int y) {
		this.setBounds(x, y, this.getWidth(), this.getHeight());
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
		return this.owner.getHeight() / 2 - this.getHeight() / 2;
	}

}
