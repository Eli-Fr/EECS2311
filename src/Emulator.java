import Interfacing.*;
import deviceCode.*;

public class Emulator {

	private static UserInterface UI;

	public static void initInterface() {
		UI = new UserInterface(9);
	}

	public static void initDevice() {

	}

	public static void main(String[] args) {
		Thread intThread = new Thread(

		) {
			public void run() {
				initInterface();
			}
		};

		Thread devThread = new Thread() {

		};

		intThread.start();
		devThread.start();
		
		
		
		System.exit(0);

	}

}
