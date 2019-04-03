package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface_Config.EditBtn;
import Interface_Config.PanelBody;
import Interface_Config.VisualFrame;

class EditBtnTest {
	
	EditBtn e;
	VisualFrame Configurator = new VisualFrame("TalkBotConfigurator");
	PanelBody pb = new PanelBody(Configurator);
	@Test
	void testEditBtn() {
		e = new EditBtn("Hello", pb);
		assertEquals("Hello", e.getName());
		assertEquals("/" + pb.getConfig().getRelativePathToAudioFiles().toString(), e.getAudFile());
		assertEquals("/" + pb.getConfig().getRelativePathToAudioFiles().toString(), e.getAudFile());
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
