package Config;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class ConfigPanel extends AbstractPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainPanelButton IB;

	private ConfigPanelButton goBack, Record;
	private MainPanel mainP;

	private FileSelectorButton chooseAudio, chooseImage;
	private JLabel drag;

	private String AudioName, ImageName, Name;

	private AudioObject audObj;

//page: 1 button: 3 name: angry audio: angry.wav image: angry.jpg action: play audio 

	public ConfigPanel(MainPanelButton b, MainPanel P, Configurator C) {
		super(C);
		this.mainP = P;
		IB = new MainPanelButton(b, this);
		resize();

		Name = IB.getName();
		try {
			AudioName = mainP.getAudio(IB.getID()).getName();
		} catch (NullPointerException e) {
			// add button handling
		}
		ImageName = IB.getImageName();

		System.out.println(Name + " " + AudioName + " " + ImageName);

		audObj = mainP.getAudio(b.getID());
	}

	public void resize() {
		super.resize();

		chooseAudio.setBounds(this.getWidth() / 4 - chooseAudio.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, super.standardButtonSize(), 30);

		chooseImage.setBounds(this.getWidth() / 2 - chooseImage.getWidth() / 2,
				this.getHeight() * 3 / 4 - chooseAudio.getHeight() / 2, standardButtonSize(), 30);

		drag.setBounds(this.getWidth() * 3 / 4 - drag.getWidth() / 2, this.getHeight() * 3 / 4 - drag.getHeight() / 2,
				standardButtonSize(), standardButtonSize());

		IB.setBounds(this.getWidth() / 2 - standardButtonSize() / 2, middleY() / 2, standardButtonSize(),
				standardButtonSize() + 30);

		goBack.setBounds(0, 0, standardButtonSize(), standardButtonSize());

		Record.setBounds(this.getWidth() * 3 / 4 - Record.getWidth() / 2, middleY() / 2, standardButtonSize(),
				standardButtonSize());
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
		Record = new ConfigPanelButton(this, "Record");

		chooseAudio.setSize(new Dimension(standardButtonSize(), 30));
		chooseImage.setSize(new Dimension(standardButtonSize(), 30));
		goBack.setSize(new Dimension(standardButtonSize(), standardButtonSize()));
		drag.setSize(new Dimension(standardButtonSize(), standardButtonSize()));
		Record.setSize(new Dimension(standardButtonSize(), standardButtonSize()));

		this.add(chooseAudio);
		this.add(chooseImage);
		this.add(drag);
		this.add(goBack);
		this.add(Record);

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

	public void UpdateImage(String imageName) {
		this.ImageName = imageName;
		IB.setImage(ImageName);

	}

	public void UpdateAudio(String AudioName) {
		this.AudioName = AudioName;
		audObj = new AudioObject(AudioName);
	}

	public void updateButton() {
		System.out.println(ImageName + " " + AudioName + " " + IB.getID());
		mainP.updateButton(IB.getID(), ImageName, AudioName, Name);
	}

	public void playAudio(int index) {
		audObj.playSound();
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
