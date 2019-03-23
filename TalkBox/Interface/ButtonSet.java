package Interface;

import java.util.ArrayList;

public class ButtonSet {

	private ArrayList<InterfaceButton> buttonList = new ArrayList<InterfaceButton>();

	public ButtonSet() {
		for (int i = 0; i < 6; i++) {
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
		return buttonList.size();
	}

	public void removeButton(int i) {
		buttonList.remove(i);
	}

}
