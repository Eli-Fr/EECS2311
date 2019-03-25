package Interface;

import java.util.ArrayList;

import javax.swing.JPanel;

import Talkbox.Emulator;

public class MainPanel extends JPanel {
	/**
	 * AUTO-GENERATED
	 */
	private static final long serialVersionUID = 1L;

	private int currentPage = 0;
	protected int totalNumberOfButtons = 0;
	private TalkBox TB;

	private InterfaceButton leftButton, rightButton;

	protected ArrayList<ButtonSet> buttonList = new ArrayList<ButtonSet>();

	public MainPanel(TalkBox TB) {
		this.TB = TB;
		setup();
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(TalkBox.DEFAULT_SCREEN_SIZE);
	}

	private void setup() {
		/**
		 * TODO change true condition when serialization is implemented
		 */
		if (true) {
			setupDefaultButtons();
		}
		leftButton = new InterfaceButton(-1, this, "LEFT", null);
		rightButton = new InterfaceButton(-1, this, "RIGHT", null);

		drawSwitchingButtons();

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
		this.setSize(TB.getCurrentDimension());
		int numOfButtons = buttonList.get(currentPage).size();
		int spacing = (TB.getWidth() - numOfButtons * TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 2))
				/ 2;
		for (int i = 0; i < numOfButtons; i++) {
			InterfaceButton alias = buttonList.get(currentPage).getButton(i);
			alias.resizeButton(TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 2),
					TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 4));
			alias.setPosition(spacing + alias.getWidth() * i, alias.middleY());
		}
		leftButton.setSize(TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 2),
				TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 4));
		rightButton.setSize(TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 2),
				TB.getWidth() / (Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE + 4));
		leftButton.setLocation(0, leftButton.middleY());
		rightButton.setLocation(TB.getWidth() - rightButton.getWidth(), rightButton.middleY());
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
		alias.setButton(index, new InterfaceButton(index, this, name, imageFile));
		if (pageNumber != getCurrentPage()) {
			alias.getButton(index).setVisible(false);
		}
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void turnButtonON(int n) throws IndexOutOfBoundsException {
		TB.turnButtonON(n);
	}

	public int getHeight() {
		return TB.getCurrentHeight();
	}

	public int getWidth() {
		return TB.getCurrentWidth();
	}

}
