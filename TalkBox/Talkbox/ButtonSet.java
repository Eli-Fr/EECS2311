package Talkbox;

import java.util.ArrayList;

public class ButtonSet {

	private ArrayList<InterfaceButton> buttonList = new ArrayList<InterfaceButton>();

	public void addButton(InterfaceButton b) {
		buttonList.add(b);
	}

	public void removeButton(int i) {
		buttonList.remove(i);
	}

}
