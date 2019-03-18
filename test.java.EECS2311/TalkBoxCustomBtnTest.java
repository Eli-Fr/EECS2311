package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface.CustomBtn;

class TalkBoxCustomBtnTest {
	CustomBtn c;

	@Test
	void testCustomBtn() throws Exception {
		c = new CustomBtn("Name", "imgFileName", 1);
		assertEquals(1, c.getId());
	}
}
