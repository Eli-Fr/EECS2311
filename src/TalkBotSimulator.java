import Interface.*;
import DeviceSpeaker.*;

public class TalkBotSimulator {

	public static void main(String[] args) {
		
		SpeakerClass sc = new SpeakerClass("kevin16");
		VisualFrame simulator = new VisualFrame("TalkBotSimulator", sc);
		

	}
	

	public static void branch1() {
		
		System.out.println("branch2");
		System.out.println("Try to make some change");
	}

}
