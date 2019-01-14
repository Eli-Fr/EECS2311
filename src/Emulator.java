import Interfacing.*;
import deviceCode.*;

public class Emulator {

	private static UserInterface UI;

	public static void initInterface() {
		UI = new UserInterface(9);
		UI.setVisible(true);
	}

	public static void initDevice() {

	}

	public static void main(String[] args) {
		initInterface();

//		Thread devThread = new Thread() {
//
//		};
//
//		devThread.start();

		// System.exit(0);

	}

}
