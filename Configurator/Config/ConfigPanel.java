package Config;

import java.awt.Color;

import javax.swing.JLabel;

public class ConfigPanel extends MainPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfaceButton IB;
	private MainPanel mainP;

	private FileSelectorButton chooseAudio, chooseImage;
	private JLabel drag;
	
//page: 1 button: 3 name: angry audio: angry.wav image: angry.jpg action: play audio 
	
	public ConfigPanel(InterfaceButton b, MainPanel P, Configurator C) {
		super(C, false);
		this.IB = new InterfaceButton(b, this);
		this.mainP = P;
		C.add(this);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setSize(Configurator.DEFAULT_SCREEN_SIZE);
		this.setSize(mainP.getSize());
		IB.setBounds(this.getWidth() / 2 - b.getWidth() / 2, b.middleY() / 2, mainP.standardButtonSize(),
				mainP.standardButtonSize() + 30);
		initComponents();
		resize();

	}

	public void resize() {
		chooseAudio.setBounds(this.getWidth() / 4 - chooseAudio.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, mainP.standardButtonSize(), 30);
		chooseImage.setBounds(this.getWidth() / 2 - chooseImage.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, mainP.standardButtonSize(), 30);
		drag.setBounds(this.getWidth() * 3 / 4 - drag.getWidth() / 2, this.getHeight() * 3 / 4 - drag.getHeight() / 2,
				mainP.standardButtonSize(), mainP.standardButtonSize());
		IB.setBounds(this.getWidth() / 2 - IB.getWidth() / 2, IB.middleY() / 2, mainP.standardButtonSize(),
				mainP.standardButtonSize() + 30);
	}

	private void initComponents() {
		chooseAudio = new FileSelectorButton("Select Audio", "Audio");
		chooseImage = new FileSelectorButton("Select Image", "Image");
		drag = new JLabel("Drag File Here");

		chooseAudio.setBounds(200, 200, mainP.standardButtonSize(), 30);
		chooseImage.setBounds(500, 200, mainP.standardButtonSize(), 30);
		drag.setBounds(650, 200, mainP.standardButtonSize(), mainP.standardButtonSize());

		this.add(chooseAudio);
		this.add(chooseImage);
		this.add(drag);

		drag.setBackground(Color.gray);
		drag.setOpaque(true);
		drag.setHorizontalAlignment(JLabel.CENTER);
		drag.setVerticalAlignment(JLabel.CENTER);

		chooseAudio.setVisible(true);
		chooseImage.setVisible(true);
		drag.setVisible(true);
		this.repaint();
	}

}
