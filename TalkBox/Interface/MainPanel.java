package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFrame;

import DeviceCode.AudioSet;
import DeviceCode.fileManager;

public abstract class MainPanel extends JFrame implements fileManager {
	/**
	 * AUTO-GENERATED
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension DEFAULT_SCREEN_SIZE = new Dimension(1280, 720);
	public static final Dimension BUTTON_SIZE = new Dimension(150, 150);

	private Dimension currentScreenSize;
	public int currentPage = 0;
	protected int totalNumberOfButtons = 0;

	protected ArrayList<ButtonSet> buttonList = new ArrayList<ButtonSet>();

	public MainPanel() {
		super();
		setup();
		getContentPane().setLayout(null);
		currentScreenSize = new Dimension((int) DEFAULT_SCREEN_SIZE.getWidth(), (int) DEFAULT_SCREEN_SIZE.getHeight());
		setSize(DEFAULT_SCREEN_SIZE);
		setResizable(false); // make this panel non resizable for now, TODO remove later
		// getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(150, 255, 150));// TODO set actual background color
	}

	private void setup() {
		/**
		 * TODO change true condition when serialization is implemented
		 */
		if (true) {
			setupDefaultButtons();
		}
	}

	private void setupDefaultButtons() {
		int listpos = 0;
		buttonList.add(new ButtonSet());
		ButtonSet alias = buttonList.get(0);
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));
		alias.addButton(new InterfaceButton(++listpos, this, "Angry", "Angry.jpg"));

	}

	public int getCurrentHeight() {
		return (int) currentScreenSize.getHeight();

	}

	public int getCurrentWidth() {
		return (int) currentScreenSize.getWidth();

	}

	public Dimension getCurrentDimension() {
		return currentScreenSize;

	}

	public void setCurrentDimension(Dimension d) {
		this.currentScreenSize = d;

	}

	public int getCurrentPage() {
		return this.currentPage;
	}

}
