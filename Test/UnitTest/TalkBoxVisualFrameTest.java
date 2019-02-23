package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import Interface.Configurator;
import Interface.VisualFrame;

class TalkBoxVisualFrameTest {
	
	VisualFrame v;
	@Test
	void testVisualFrame() throws IOException, ClassNotFoundException {
		v = new VisualFrame("test");
		FileInputStream fis = new FileInputStream("TalkBoxData/Config.tbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Configurator config = (Configurator) ois.readObject();
		assertEquals(config.getNumberOfAudioButtons(), v.getConfig().getNumberOfAudioButtons());
		assertEquals(config.getNumberOfAudioSets(), v.getConfig().getNumberOfAudioSets());
		assertEquals(config.getTotalNumberOfButtons(), v.getConfig().getTotalNumberOfButtons());
		assertEquals(config.getRelativePathToAudioFiles().toString(), v.getConfig().getRelativePathToAudioFiles().toString());
		assertEquals(config.getRelativePathToImageFiles().toString(), v.getConfig().getRelativePathToImageFiles().toString());
		for(int i = 0; i < config.getNumberOfAudioButtons(); i++) {
			assertEquals(config.getAudioFileNames()[0][i], v.getConfig().getAudioFileNames()[0][i]);
			assertEquals(config.getImageFileNames()[0][i], v.getConfig().getImageFileNames()[0][i]);
			assertEquals(config.getBtnName()[0][i], v.getConfig().getBtnName()[0][i]);
		}
		
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i], v.getConfig().getSetBtn()[i]);
		}

	}


}
