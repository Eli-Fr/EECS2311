package Main;

import Device.ButtonInterface;
import Device.Device;
import Device.FileManager;
import Interface.*;

public class TalkBoxSimulator {

	/**
	 * List of Constants for the program
	 */
	public static final int MAX_NUMBER_OF_BUTTONS_PER_PAGE = 8;

	/**
	 * List of objects
	 */
	public static TalkBoxUI simulator;
	public static Device D;
	public static FileManager FM;
	public static ButtonInterface BI;

	public static void main(String[] args) {

		// TODO: Add a prompt for the user to select between a default TB or use a cfg

		// TODO: change null to config file name
		FM = new FileManager(null);

		BI = new ButtonInterface();
		simulator = new TalkBoxUI("TalkBotSimulator", FM.getConfig(), BI);
		D = new Device(BI, FM);

	}

}
