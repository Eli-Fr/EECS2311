package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Device.ButtonInterface;
import Device.Device;
import Device.FileManager;

class DeviceTest {

	ButtonInterface bi = new ButtonInterface();
	FileManager f = new FileManager("Config.tbc");
	Device d = new Device(bi, f);
	


	@Test
	void testTurnButtonON() {
		d.turnButtonOff(1);
		assertEquals(0, bi.get(1));
		d.turnButtonON(1);
		assertEquals(1, bi.get(1));
	}
	
	@Test
	void testTurnButtonOff() {
		d.turnButtonON(1);
		assertEquals(1, bi.get(1));
		d.turnButtonOff(1);
		assertEquals(0, bi.get(1));
	}
	
	@Test
	public void testException(){
		assertThrows(IndexOutOfBoundsException.class, () -> d.turnButtonOff(100));
		assertThrows(IndexOutOfBoundsException.class, () -> d.turnButtonON(100));
	}

}
