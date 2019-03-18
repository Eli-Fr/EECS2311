package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface_Config.EditBtn;

class EditBtnTest {
	
	EditBtn e;
	@Test
	void testEditBtn() {
		e = new EditBtn("name", "imgPath", "audPath");
		assertEquals("name", e.getName());
		assertEquals("/imgPath", e.getImgFile());
		assertEquals("/audPath", e.getAudFile());
	}

//	@Test
//	void testInitMain() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitImage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitAudio() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInitConfirm() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testActionPerformed() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetImgFile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAudFile() {
//		fail("Not yet implemented");
//	}

}
