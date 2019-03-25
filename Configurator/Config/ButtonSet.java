package Config;

import java.util.ArrayList;

import Talkbox.Emulator;

public class ButtonSet {

	private ArrayList<InterfaceButton> buttonList = new ArrayList<InterfaceButton>();

	public ButtonSet() {
		for (int i = 0; i < Emulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE; i++) {
			buttonList.add(null);
		}
	}

	public InterfaceButton getButton(int index) {
		return buttonList.get(index);
	}

	public void addButton(InterfaceButton b) {
		buttonList.add(b);
	}

	public void setButton(int index, InterfaceButton b) {
		buttonList.set(index, b);
	}

	public int size() {
		for (int i = 0; i < buttonList.size(); i++) {
			if (buttonList.get(i) == null) {
				return i;
			}
		}
		return buttonList.size();
	}

	public void removeButton(int i) {
		buttonList.remove(i);
	}

}
