package Device;

import Main.TalkBoxSimulator;

public class ButtonInterface {

	private int[] buttonList;
	
	public ButtonInterface() {
		buttonList = new int[TalkBoxSimulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE];
		this.fill();
	}

	/**
	 * 
	 * @param n
	 */
	public void turnOnButton(int n) {
		buttonList[n] = 1;
	}

	/**
	 * 
	 * @param n
	 */
	public void turnOffButton(int n) {
		buttonList[n] = 0;
	}

	/**
	 * 
	 */
	private void fill() {
		for (int i = 0; i < buttonList.length; i++) {
			buttonList[i] = 0;
		}
	}

	public int get(int n) {
		return buttonList[n];
	}

	public int size() {
		return buttonList.length;
	}
}
