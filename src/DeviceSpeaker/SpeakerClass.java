package DeviceSpeaker;

import com.sun.speech.freetts.VoiceManager;

public class SpeakerClass {

	private String name;
	
	private com.sun.speech.freetts.Voice voice;
	
	public SpeakerClass(String name) {
		
		this.name = name;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();
		
	}
	
	public void say(String word) {
		
		this.voice.speak(word);
		
	}
	
}
