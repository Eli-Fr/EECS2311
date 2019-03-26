package Interface;

import java.util.ArrayList;

import Talkbox.Emulator;

/**
 * This class contains a number of buttons that represents a page in the talkbox
 * 
 * @author Eli Frungorts, Yash Desai, Kai Xu
 *
 */
public class ButtonSet {

	private ArrayList<InterfaceButton> buttonList = new ArrayList<InterfaceButton>();

	/**
	 * Initialized an arraylist of null objects that will be set as the page is
	 * constructed
	 */
	public ButtonSet() {
		for (int i = 0; i < Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE; i++) {
			buttonList.add(null);
		}
	}

	/**
	 * @param index
	 * @return InterfaceButton at index n
	 */
	public InterfaceButton getButton(int index) {
		return buttonList.get(index);
	}

	/**
	 * @deprecated
	 * @param b
	 */
	public void addButton(InterfaceButton b) {
		buttonList.add(b);
	}

	/**
	 * sets Button at index to button b
	 * 
	 * @param index
	 * @param b
	 */
	public void setButton(int index, InterfaceButton b) {
		buttonList.set(index, b);
	}

	/**
	 * 
	 * @return the distance before the first null object
	 */
	public int size() {
		for (int i = 0; i < buttonList.size(); i++) {
			if (buttonList.get(i) == null) {
				return i;
			}
		}
		return buttonList.size();
	}

	/**
	 * @deprecated
	 * @param i
	 */
	public void removeButton(int i) {
		buttonList.remove(i);
	}

}
