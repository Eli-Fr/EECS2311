package Talkbox;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfaceButton extends JButton {

	private int listPos;
	private TalkBox owner;

	public InterfaceButton(int listPos, TalkBox owner) {
		this.listPos = listPos;
		this.owner = owner;
	}

	public void act() {
		owner.turnButtonON(this.listPos);

	}
}
