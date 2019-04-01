package Interface;

import javax.swing.*;

import Device.ButtonInterface;

public class TalkBoxUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbstractPanel mainPanel;

	private Configurator CG;
	private ButtonInterface BI;

	public TalkBoxUI(String title, Configurator CG, ButtonInterface BI) {
		super(title);
		this.pack();
		this.BI = BI;
		this.CG = CG;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.setSize(1280 * CG.getRatio(), 720 * CG.getRatio());

		mainPanel = new MainPanel(this);

		this.setContentPane(mainPanel);
		this.setVisible(true);
	}

	public Configurator getConfig() {
		return this.CG;
	}

	public ButtonInterface getButtonInterface() {
		return this.BI;
	}

}
