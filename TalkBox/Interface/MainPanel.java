package Interface;

import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	/**
	 * AUTO-GENERATED
	 */
	private static final long serialVersionUID = 1L;

	public int currentPage = 0;
	protected int totalNumberOfButtons = 0;
	private TalkBox TB;

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
	}

	public void resize() {
		int numOfButtons = buttonList.get(currentPage).size();
		int spacing = (TB.getWidth() - numOfButtons * 100) / 2;
		for (int i = 0; i < numOfButtons; i++) {
			InterfaceButton alias = buttonList.get(currentPage).getButton(i);
			alias.setBounds(spacing + 100 * i, alias.middleY(), alias.getWidth(), alias.getHeight());
		}
	}

	private void setupDefaultButtons() {
		buttonList.add(new ButtonSet());
		for (int listPos = 0; listPos < 6; listPos++) {
			this.setButton(0, listPos, "Angry", "Angry.jpg");
		}
	}

	private void setButton(int pageNumber, int index, String name, String ImageFile) {
		ButtonSet alias = buttonList.get(pageNumber);
		alias.setButton(index, new InterfaceButton(index, this, "Angry", "Angry.jpg"));
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
