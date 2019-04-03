package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Device.ButtonInterface;
import Interface.Configurator;
import Interface.TalkBoxUI;

class TalkBoxUITest {

	@Test
	void testTalkBoxUI() {
		ButtonInterface bi = new ButtonInterface();
		Configurator c = new Configurator();
		TalkBoxUI tui = new TalkBoxUI("a", c, bi);
		assertEquals(bi, tui.getButtonInterface());
		assertEquals(c, tui.getConfig());
	}

}
