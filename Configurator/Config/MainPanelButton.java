package Config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import DeviceCode.fileManager;

public class MainPanelButton extends AbstractButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon image;
	private int listPos;
	private String imageName;

	private MainPanel Owner;

	public MainPanelButton(MainPanel owner, int listPos, String name, String imageName) {
		super(owner, name);
		this.Owner = (MainPanel) owner;

		this.listPos = listPos;

		this.setImageName(imageName);
		this.setImage(imageName);

		this.setBackground(Color.white);
	}

	public MainPanelButton(MainPanelButton other, AbstractPanel p) {
		super(p, other.getName());
		this.setName(other.getName());
		p.add(this);
		this.listPos = other.listPos;
		this.setImage(other.getImageName());
		this.setImageName(other.getImageName());
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
		MainPanelButton ib = (MainPanelButton) e.getSource();

		if (ib.getOwner().getClass() == ConfigPanel.class) {
			ConfigPanel cp = (ConfigPanel) getOwner();
			cp.playAudio(listPos);
		} else {
			if (ib.listPos < 0) {
				if (this.getName().equals("LEFT")) {
					Owner.LoadSet(Owner.getCurrentPage() - 1);
				} else if (this.getName().equals("RIGHT")) {
					Owner.LoadSet(Owner.getCurrentPage() + 1);
				}
			} else {
				Owner.openConfig(this);
			}
		}
	}

	public void setPosition(int x, int y) {
		this.setBounds(x, y, this.getWidth(), this.getHeight());
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int middleY() {
		return this.Owner.getHeight() / 2 - this.getHeight() / 2;
	}

}
