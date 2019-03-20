package Talkbox;

import Interface.TalkBox;
import DeviceCode.Device;

public class Emulator {

	public static void main(String[] args) {
		ButtonInterface BI = new ButtonInterface();
		TalkBox tb = new TalkBox(BI);
		Device D = new Device(BI, tb);
		tb.setVisible(true);
	}

}
