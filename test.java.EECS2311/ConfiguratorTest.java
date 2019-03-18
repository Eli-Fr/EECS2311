package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Interface.Configurator;

class ConfiguratorTest {
	
	Configurator c;
	String[][] s1 = {{"Happy", "Sad"}, {"Good", "Bad"}};
	String[] s2 = {"Happy", "Sad"};

	@Test
	void testGetBtnName() {
		c = new Configurator();
		c.setBtnName(s1);
		assertEquals("Happy", c.getBtnName()[0][0]);
		assertEquals("Sad", c.getBtnName()[0][1]);
		assertEquals("Good", c.getBtnName()[1][0]);
		assertEquals("Bad", c.getBtnName()[1][1]);	
	}


	@Test
	void testGetSetBtn() {
		c = new Configurator();
		c.setSetBtn(s2);
		assertEquals("Happy", c.getSetBtn()[0]);
		assertEquals("Sad", c.getSetBtn()[1]);
	}

	@Test
	void testGetSetNum() {
		c = new Configurator();
		c.setSetNum(5);
		assertEquals(5, c.getSetNum());
	}

	@Test
	void testGetRatio() {
		c = new Configurator();
		c.setRatio(5);
		assertEquals(5, c.getRatio());
	}

	@Test
	void testGetRelativePathToImageFiles() {
		c = new Configurator();
		c.setRelativePathToImageFiles("C:\\Users");
		Path p = Paths.get("C:\\Users");
		assertEquals(p, c.getRelativePathToImageFiles());
	}


	@Test
	void testGetImageFileNames() {
		c = new Configurator();
		c.setImageFileNames(s1);
		assertEquals("Happy", c.getImageFileNames()[0][0]);
		assertEquals("Sad", c.getImageFileNames()[0][1]);
		assertEquals("Good", c.getImageFileNames()[1][0]);
		assertEquals("Bad", c.getImageFileNames()[1][1]);	
	}

	@Test
	void testGetNumberOfAudioButtons() {
		c = new Configurator();
		c.setNumberOfAudioButtons(5);
		assertEquals(5, c.getNumberOfAudioButtons());
	}

	@Test
	void testGetNumberOfAudioSets() {
		c = new Configurator();
		c.setNumberOfAudioSets(5);
		assertEquals(5, c.getNumberOfAudioSets());
	}

	@Test
	void testGetTotalNumberOfButtons() {
		c = new Configurator();
		c.setTotalNumberOfButtons(5);
		assertEquals(5, c.getTotalNumberOfButtons());
	}

	@Test
	void testGetRelativePathToAudioFiles() {
		c = new Configurator();
		c.setRelativePathToAudioFiles("C:\\Users");
		Path p = Paths.get("C:\\Users");
		assertEquals(p, c.getRelativePathToAudioFiles());
	}

	@Test
	void testGetAudioFileNames() {
		c = new Configurator();
		c.setAudioFileNames(s1);
		assertEquals("Happy", c.getAudioFileNames()[0][0]);
		assertEquals("Sad", c.getAudioFileNames()[0][1]);
		assertEquals("Good", c.getAudioFileNames()[1][0]);
		assertEquals("Bad", c.getAudioFileNames()[1][1]);	
	}

}
