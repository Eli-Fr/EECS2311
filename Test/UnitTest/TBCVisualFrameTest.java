package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import Interface.Configurator;
import TBC_Interface.VisualFrame;

class TBCVisualFrameTest {

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
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			for (int j = 0; j < config.getAudioFileNames()[i].length; j++) {
				assertEquals(config.getAudioFileNames()[i][j], v.getConfig().getAudioFileNames()[i][j]);
				assertEquals(config.getImageFileNames()[i][j], v.getConfig().getImageFileNames()[i][j]);
				assertEquals(config.getBtnName()[i][j], v.getConfig().getBtnName()[i][j]);
			}
		}
		
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i], v.getConfig().getSetBtn()[i]);
		}
	}

}
