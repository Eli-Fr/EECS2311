package Interface;

import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;

import Device.ButtonInterface;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class AudioButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	private String name, imgFileName;
	private int id;

	private BodyPanel owner;
	private ButtonInterface BI;

	public AudioButton(ButtonInterface BI, BodyPanel owner, String name, String imgFileName, int id) {
		super(name);

		this.owner = owner;
		this.BI = BI;
		this.setImg(imgFileName);
		this.setName(name);
		this.setId(id);
		
		this.addActionListener(this);

		this.setHorizontalTextPosition(AbstractButton.CENTER);
		this.setVerticalTextPosition(AbstractButton.BOTTOM);

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

	public void setImg(String imgFileName) {
		this.imgFileName = imgFileName;
		if (imgFileName == null) {

		} else {
			try {
				this.image = new ImageIcon(
						ImageIO.read(new File(imgFileName)));
			} catch (IOException e) {
				System.out.println("no image found");
			}
			scaleImage(image, 100, 100);
			this.setIcon(image);
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BI.turnOnButton(this.id);
	}

}
