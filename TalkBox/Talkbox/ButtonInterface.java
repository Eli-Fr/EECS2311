package Talkbox;

import java.util.ArrayList;

import javax.naming.SizeLimitExceededException;

public class ButtonInterface {

	private ArrayList<Integer> buttonList;
	private int numberOfButtons;

	public ButtonInterface() {
		buttonList = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			try {
				addButton();
			} catch (SizeLimitExceededException e) {
				System.out.println("sizeLimitExceeded");
			}
		}
	}

	/**
	 * 
	 * @param n
	 */
	public void turnOnButton(int n) {
		buttonList.set(n, new Integer(1));
	}

	/**
	 * 
	 * @param n
	 */
	public void turnOffButton(int n) {
		buttonList.set(n, new Integer(0));
	}

	public void addButton() throws SizeLimitExceededException {
		if (numberOfButtons > 6) {
			throw new SizeLimitExceededException();
		}
		buttonList.add(new Integer(0));

	}

	/**
	 * 
	 */
	public void removeButton() throws IndexOutOfBoundsException {
		if (numberOfButtons <= 0) {
			throw new IndexOutOfBoundsException();
		}
		buttonList.remove(buttonList.size() - 1);

	}

	/**
	 * 
	 */
	public void removeAll() {
		buttonList = new ArrayList<Integer>();

	}

	/**
	 * 
	 */
	public void fill() {
		while (buttonList.size() < 6) {
			try {
				this.addButton();
			} catch (SizeLimitExceededException e) {
			}
		}
	}

	public Integer get(int n) {
		return buttonList.get(n);
	}

	public int size() {
		return buttonList.size();
	}
}
