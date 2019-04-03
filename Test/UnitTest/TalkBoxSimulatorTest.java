package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import Device.ButtonInterface;
import Device.Device;
import Device.FileManager;
import Interface.Configurator;
import Main.TalkBoxSimulator;

class TalkBoxSimulatorTest {
	
	@Test
	void test() throws IOException, ClassNotFoundException {
		TalkBoxSimulator t = new TalkBoxSimulator();
		t.main(null);
		t.init("Default.tbc");
		FileManager f = new FileManager(null);
		FileInputStream fis = new FileInputStream("TalkBoxData" + System.getProperty("file.separator") + "Default.tbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Configurator config = (Configurator) ois.readObject();

		assertEquals(config.getNumberOfAudioButtons(), t.FM.getConfig().getNumberOfAudioButtons());
		assertEquals(config.getNumberOfAudioSets(),  t.FM.getConfig().getNumberOfAudioSets());
		assertEquals(config.getTotalNumberOfButtons(),  t.FM.getConfig().getTotalNumberOfButtons());
		assertEquals(config.getRelativePathToAudioFiles().toString(),
				f.getConfig().getRelativePathToAudioFiles().toString());
		assertEquals(config.getRelativePathToImageFiles().toString(),
				f.getConfig().getRelativePathToImageFiles().toString());
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			for (int j = 0; j < config.getAudioFileNames()[i].length; j++) {
				assertEquals(config.getAudioFileNames()[i][j], t.FM.getAudioFiles()[i][j]);
				assertEquals(config.getImageFileNames()[i][j],  t.FM.getImageFiles()[i][j]);
				assertEquals(config.getBtnName()[i][j],  t.FM.getConfig().getBtnName()[i][j]);
			}
		}
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i],  t.FM.getConfig().getSetBtn()[i]);
		}
		assertEquals(new ButtonInterface().size(), t.BI.size());
	
	}

}
