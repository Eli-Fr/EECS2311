package Config;

import java.awt.Color;

import javax.swing.JLabel;

public class ConfigPanel extends AbstractPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainPanelButton IB;
	private MainPanelButton tmp;

	private ConfigPanelButton goBack;
	private MainPanel mainP;

	private FileSelectorButton chooseAudio, chooseImage;
	private JLabel drag;

	private String AudioName, ImageName, Name;

//page: 1 button: 3 name: angry audio: angry.wav image: angry.jpg action: play audio 

	public ConfigPanel(MainPanelButton b, MainPanel P, Configurator C) {
		super(C);
		this.mainP = P;
		IB = new MainPanelButton(b, this);
		resize();
	}

	public void resize() {
		super.resize();

		chooseAudio.setBounds(this.getWidth() / 4 - chooseAudio.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, super.standardButtonSize(), 30);

		chooseImage.setBounds(this.getWidth() / 2 - chooseImage.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, super.standardButtonSize(), 30);

		drag.setBounds(this.getWidth() * 3 / 4 - drag.getWidth() / 2, this.getHeight() * 3 / 4 - drag.getHeight() / 2,
				super.standardButtonSize(), super.standardButtonSize());

		IB.setBounds(this.getWidth() / 2 - IB.getWidth() / 2, this.middleY() / 2, super.standardButtonSize(),
				super.standardButtonSize() + 30);

		goBack.setBounds(0, 0, super.standardButtonSize(), super.standardButtonSize());

	}

	public void closeConfig() {
		mainP.closeConfig();
	}

	public void acceptChange() {

	}

	private void resetChange() {

	}

	protected void initComponents() {
		chooseAudio = new FileSelectorButton(this, "Select Audio", "Audio");
		chooseImage = new FileSelectorButton(this, "Select Image", "Image");
		goBack = new ConfigPanelButton(this, "Go Back");
		drag = new JLabel("Drag File Here");

		chooseAudio.setBounds(200, 200, this.standardButtonSize(), 30);
		chooseImage.setBounds(500, 200, this.standardButtonSize(), 30);
		goBack.setBounds(0, 0, this.standardButtonSize(), this.standardButtonSize());
		drag.setBounds(650, 200, this.standardButtonSize(), this.standardButtonSize());

		this.add(chooseAudio);
		this.add(chooseImage);
		this.add(drag);
		this.add(goBack);

		drag.setBackground(Color.gray);
		drag.setOpaque(true);
		drag.setHorizontalAlignment(JLabel.CENTER);
		drag.setVerticalAlignment(JLabel.CENTER);

		goBack.setBackground(Color.WHITE);
		goBack.setOpaque(true);
		goBack.setHorizontalAlignment(JLabel.CENTER);
		goBack.setVerticalAlignment(JLabel.CENTER);

		chooseAudio.setVisible(true);
		chooseImage.setVisible(true);
		drag.setVisible(true);
		goBack.setVisible(true);
		this.repaint();

	}

	public void playAudio(int index) {
		mainP.playAudio(index);
	}

	public String getAudioName() {
		return AudioName;
	}

	public void setAudioName(String audioName) {
		AudioName = audioName;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

}
