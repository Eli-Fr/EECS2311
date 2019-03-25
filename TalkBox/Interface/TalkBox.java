package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Talkbox.ButtonInterface;

public class TalkBox extends JFrame implements ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension DEFAULT_SCREEN_SIZE = new Dimension(1280, 720);
	public static final Dimension BUTTON_SIZE = new Dimension(150, 150);

	private Dimension currentScreenSize;

	private ButtonInterface BI;
	private MainPanel mainP;

	public TalkBox(ButtonInterface BI) {
		super();
		currentScreenSize = new Dimension((int) DEFAULT_SCREEN_SIZE.getWidth(), (int) DEFAULT_SCREEN_SIZE.getHeight());
		this.setMinimumSize(DEFAULT_SCREEN_SIZE);
		pack();
		this.BI = BI;
		this.mainP = new MainPanel(this);
		initComponents();
		this.add(mainP);
		setSize(DEFAULT_SCREEN_SIZE);
		getContentPane().setLayout(null);
		addComponentListener(this);
		getContentPane().setBackground(new Color(150, 255, 150));// TODO set actual background color
	}

	public void initComponents() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				/**
				 * TODO ADD events that will happen when we close the window, this can include
				 * saving the current config. we can call the method saveConfig();
				 */
				System.exit(0);
			}
		});
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
		return mainP.getCurrentPage();
	}

	public MainPanel getMainPanel() {
		return this.mainP;
	}

	public void turnButtonON(int n) throws IndexOutOfBoundsException {
		BI.turnOnButton(n);
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		this.setCurrentDimension(this.getSize());
		mainP.resize();

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
