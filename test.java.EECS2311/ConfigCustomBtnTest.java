package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface_Config.CustomBtn;

class ConfigCustomBtnTest {
	
	CustomBtn c;
	@Test
	void testCustomBtn() {
		c = new CustomBtn("name", "Hello.jpg", 1, "wavFileName");
		assertEquals("Hello.jpg", c.getImgFileName());
		assertEquals("wavFileName", c.getWavFileName());
		assertEquals(1, c.getId());
	}

}
