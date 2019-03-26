package Config;

import java.util.ArrayList;

public class MainPanel extends AbstractPanel {
	/**
	 * AUTO-GENERATED
	 */
	private static final long serialVersionUID = 1L;

	private int currentPage = 0;
	protected int totalNumberOfButtons = 0;

	private MainPanelButton leftButton, rightButton;
	private ConfigPanel cPan;

	protected ArrayList<ButtonSet> buttonList;
	protected ArrayList<AudioSet> audioList;

	public MainPanel(Configurator cfg) {
		super(cfg);
	}

	private void drawSwitchingButtons() {
		leftButton.setVisible(hasLeftPage());
		rightButton.setVisible(hasRightPage());
	}

	private boolean hasLeftPage() {
		try {
			buttonList.get(currentPage - 1);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean hasRightPage() {
		try {
			buttonList.get(currentPage + 1);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public void playAudio(int n) {

	}

	public void openConfig(MainPanelButton b) {
		this.setVisible(false);
		cPan = new ConfigPanel(b, this, this.getCFG());
		cPan.setVisible(true);
	}

	public void closeConfig() {
		cPan.setVisible(false);
		this.setVisible(true);
	}

	public void LoadSet(int n) {
		for (int i = 0; i < buttonList.get(currentPage).size(); i++) {
			buttonList.get(currentPage).getButton(i).setVisible(false);
		}
		currentPage = n;
		for (int i = 0; i < buttonList.get(currentPage).size(); i++) {
			buttonList.get(currentPage).getButton(i).setVisible(true);
		}
		resize();
		drawSwitchingButtons();
	}

	public void resize() {
		super.resize();

		int numOfButtons = buttonList.get(currentPage).size();
		int spacing = (this.getCFG().getWidth()
				- numOfButtons * this.getCFG().getWidth() / (this.getCFG().maxNumberOfButtons + 2)) / 2;
		for (int i = 0; i < numOfButtons; i++) {
			MainPanelButton alias = buttonList.get(currentPage).getButton(i);
			alias.resizeButton(standardButtonSize(), standardButtonSize());
			alias.setPosition(spacing + alias.getWidth() * i, alias.middleY());
		}
		leftButton.setSize(standardButtonSize(), standardButtonSize());
		rightButton.setSize(standardButtonSize(), standardButtonSize());
		leftButton.setLocation(0, leftButton.middleY());
		rightButton.setLocation(this.getCFG().getWidth() - rightButton.getWidth(), rightButton.middleY());
		try {
			cPan.resize();
		} catch (Exception e) {

		}
	}

	private void setupDefaultButtons() {
		int listPos = 0;
		// page 0
		setButton(0, listPos, "Angry", "Angry.jpg");
		setButton(0, ++listPos, "Happy", "Happy.jpg");
		setButton(0, ++listPos, "Sad", "Sad.jpg");
		setButton(0, ++listPos, "Tired", "Tired.jpg");
		setButton(0, ++listPos, "Hungry", "Hungry.jpg");

		// page 1
		listPos = 0;
		setButton(1, listPos, "Hello", "Hello.jpg");
		setButton(1, ++listPos, "Goodbye", "Goodbye.jpg");
		setButton(1, ++listPos, "Sleep", "Sleep.jpg");
		setButton(1, ++listPos, "WashRoom", "Wash Room.jpg");

	}

	private void setButton(int pageNumber, int index, String name, String imageFile) {
		ButtonSet alias = null;
		try {
			alias = buttonList.get(pageNumber);
		} catch (Exception e) {
			buttonList.add(new ButtonSet());
		}

		alias = buttonList.get(pageNumber);
		alias.setButton(index, new MainPanelButton(this, index, name, imageFile));
		if (pageNumber != getCurrentPage()) {
			alias.getButton(index).setVisible(false);
		}
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	@Override
	protected void initComponents() {
		buttonList = new ArrayList<ButtonSet>();
		audioList = new ArrayList<AudioSet>();
		/**
		 * TODO change true condition when serialization is implemented
		 */
		if (getCFG().configFound()) {

		} else {
			setupDefaultButtons();
		}
		leftButton = new MainPanelButton(this, -1, "LEFT", null);
		rightButton = new MainPanelButton(this, -1, "RIGHT", null);

		drawSwitchingButtons();

	}

}
