package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Device.ButtonInterface;
import Main.TalkBoxSimulator;

class ButtonInterfaceTest {

	ButtonInterface bi = new ButtonInterface();
	
	@Test
	void testSize() {
		assertEquals(TalkBoxSimulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE, bi.size());
	}
	
	@Test
	void testFill() {
		ButtonInterface b = new ButtonInterface();
		for (int i = 0; i < b.size(); i++) {
			assertEquals(TalkBoxSimulator.MAX_NUMBER_OF_BUTTONS_PER_PAGE, b.size());
			assertEquals(0, b.get(i));
		}
		
	}
	
	@Test
	void testTurnOnButton() {
		bi.turnOffButton(3);
		assertEquals(0, bi.get(3));
		bi.turnOnButton(2);
		assertEquals(1, bi.get(2));
	}

	@Test
	void testTurnOffButton() {
		bi.turnOnButton(3);
		assertEquals(1, bi.get(3));
		bi.turnOffButton(3);
		assertEquals(0, bi.get(3));
	}



}
