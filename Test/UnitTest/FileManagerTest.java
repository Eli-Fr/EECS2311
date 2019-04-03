package UnitTest;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import Device.FileManager;
import Interface.Configurator;
import Interface_Config.VisualFrame;

class FileManagerTest {

	@Test
	void testSetDefaults() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileManager f = new FileManager(null);
		FileInputStream fis = new FileInputStream("TalkBoxData" + System.getProperty("file.separator") + "Default.tbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Configurator config = (Configurator) ois.readObject();

		assertEquals(config.getNumberOfAudioButtons(), f.getConfig().getNumberOfAudioButtons());
		assertEquals(config.getNumberOfAudioSets(), f.getConfig().getNumberOfAudioSets());
		assertEquals(config.getTotalNumberOfButtons(), f.getConfig().getTotalNumberOfButtons());
		assertEquals(config.getRelativePathToAudioFiles().toString(),
				f.getConfig().getRelativePathToAudioFiles().toString());
		assertEquals(config.getRelativePathToImageFiles().toString(),
				f.getConfig().getRelativePathToImageFiles().toString());
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			for (int j = 0; j < config.getNumberOfAudioButtons(); j++) {
				assertEquals(config.getAudioFileNames()[i][j], f.getAudioFiles()[i][j]);
				assertEquals(config.getImageFileNames()[i][j], f.getImageFiles()[i][j]);
				assertEquals(config.getBtnName()[i][j], f.getConfig().getBtnName()[i][j]);
			}
		}
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i], f.getConfig().getSetBtn()[i]);
		}

	}

	@Test
	void testSetup() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileManager f = new FileManager("Config.tbc");
		FileInputStream fis = new FileInputStream("TalkBoxData" + System.getProperty("file.separator") + "Config.tbc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Configurator config = (Configurator) ois.readObject();

		assertEquals(config.getNumberOfAudioButtons(), f.getConfig().getNumberOfAudioButtons());
		assertEquals(config.getNumberOfAudioSets(), f.getConfig().getNumberOfAudioSets());
		assertEquals(config.getTotalNumberOfButtons(), f.getConfig().getTotalNumberOfButtons());
		assertEquals(config.getRelativePathToAudioFiles().toString(),
				f.getConfig().getRelativePathToAudioFiles().toString());
		assertEquals(config.getRelativePathToImageFiles().toString(),
				f.getConfig().getRelativePathToImageFiles().toString());
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			for (int j = 0; j < config.getAudioFileNames()[i].length; j++) {
				assertEquals(config.getAudioFileNames()[i][j], f.getConfig().getAudioFileNames()[i][j]);
				assertEquals(config.getImageFileNames()[i][j], f.getConfig().getImageFileNames()[i][j]);
				assertEquals(config.getBtnName()[i][j], f.getConfig().getBtnName()[i][j]);
			}
		}
		for (int i = 0; i < config.getNumberOfAudioSets(); i++) {
			assertEquals(config.getSetBtn()[i], f.getConfig().getSetBtn()[i]);
		}
	}
	
	@Test
	void testFileNotFoundException() {
		assertThrows(
 			 FileNotFoundException.class,
				() -> {FileManager f = new FileManager(null);
					FileInputStream fis = new FileInputStream("TalkBoxData/Config");}
				);
	}
	
	@Test
	void testIOException() {
		assertThrows(
 			 FileNotFoundException.class,
				() -> {FileManager f = new FileManager(null);
				FileInputStream fis = new FileInputStream("TalkBoxData/Config");
				ObjectInputStream ois = new ObjectInputStream(fis);
				}
				);
	}
	
	@Test
	void testClassNotFoundException() {
		assertThrows(
 			 FileNotFoundException.class,
				() -> {FileManager f = new FileManager(null);
				FileInputStream fis = new FileInputStream("TalkBoxData/Config");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Interface_Config.PanelBody config = (Interface_Config.PanelBody) ois.readObject();}
				);
	}
}

