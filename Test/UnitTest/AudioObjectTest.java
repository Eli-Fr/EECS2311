package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Device.AudioObject;
import Device.FileManager;
import Main.TalkBoxSimulator;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

class AudioObjectTest {
	FileManager fm = new FileManager("Config.tbc");
	@Test
	void testAudioObject() {
		AudioObject ao = new AudioObject("/Happy.Wav", fm);
		assertEquals("/Happy.Wav", ao.getName());
	}

	@Test
	void testPlaySound() throws FileNotFoundException, IOException {
		AudioObject ao = new AudioObject("/Happy.Wav", fm);
		ao.playSound();
		AudioStream as = new AudioStream(new FileInputStream(fm.getConfig().getRelativePathToAudioFiles()+ "/Happy.Wav"));
		assertEquals(as.getLength(), ao.getPrevious().getLength());
	}

}
