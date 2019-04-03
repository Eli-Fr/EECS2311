package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import Interface.Configurator;
import Interface_Config.PanelBody;
import Interface_Config.VisualFrame;

class ConfigPanelBodyTest {
	VisualFrame v;
	PanelBody p;
//	@Test
//	void testPanelBody() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitBtn() {
//		fail("Not yet  implemented");
//	}
//
//	@Test
//	void testInitSet() {
//		fail("Not yet implemented");
//	}
//

	@Test
	void testGetConfig() throws IOException, ClassNotFoundException {
		v = new VisualFrame("test");
		p = new PanelBody(v);
		FileInputStream fis = new FileInputStream("TalkBoxData/Default.tbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Configurator config = (Configurator) ois.readObject();
		assertEquals(config.getNumberOfAudioButtons(), p.getConfig().getNumberOfAudioButtons());
		assertEquals(config.getNumberOfAudioSets(), p.getConfig().getNumberOfAudioSets());
		assertEquals(config.getTotalNumberOfButtons(), p.getConfig().getTotalNumberOfButtons());
		assertEquals(config.getRelativePathToAudioFiles().toString(), p.getConfig().getRelativePathToAudioFiles().toString());
		assertEquals(config.getRelativePathToImageFiles().toString(), p.getConfig().getRelativePathToImageFiles().toString());
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			for (int j = 0; j < config.getNumberOfAudioButtons(); j++) {
				assertEquals(config.getAudioFileNames()[i][j], p.getConfig().getAudioFileNames()[i][j]);
				assertEquals(config.getImageFileNames()[i][j], p.getConfig().getImageFileNames()[i][j]);
				assertEquals(config.getBtnName()[i][j], p.getConfig().getBtnName()[i][j]);
			}
		}
		for(int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i], p.getConfig().getSetBtn()[i]);
		}
	}

}
