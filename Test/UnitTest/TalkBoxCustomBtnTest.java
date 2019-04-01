package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface.AudioButton;

class TalkBoxCustomBtnTest {
	AudioButton c;

	@Test
	void testCustomBtn() throws Exception {
		c = new AudioButton("Name", "imgFileName", 1);
		assertEquals(1, c.getId());
	}
}
