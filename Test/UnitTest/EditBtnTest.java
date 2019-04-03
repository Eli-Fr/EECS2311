package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import Interface_Config.EditBtn;
import Interface_Config.PanelBody;
import Interface_Config.VisualFrame;

class EditBtnTest {
	
	EditBtn e;
	VisualFrame Configurator = new VisualFrame("TalkBotConfigurator", new File("TalkBoxData/Default.tbc"));
	PanelBody pb = new PanelBody(Configurator);
	@Test
	void testEditBtn() {
		e = new EditBtn("Hello", pb);
		assertEquals("Hello", e.getName());
		assertEquals("/" + pb.getConfig().getRelativePathToAudioFiles().toString(), e.getAudFile());
		assertEquals("/" + pb.getConfig().getRelativePathToAudioFiles().toString(), e.getAudFile());
	}


	@Test
	void testGetImgFile() {
		e = new EditBtn("Hello", pb);
		assertEquals("/TalkBoxData\\Icon", e.getImgFile());
	}

	@Test
	void testGetImgChange() {
		e = new EditBtn("Hello", pb);
		assertFalse(e.getImgChange());
	}
	
	@Test
	void testGetAudChange() {
		e = new EditBtn("Hello", pb);
		assertFalse(e.getAudChange());
	}
	
	@Test
	void testActionPerformed() {
		e = new EditBtn("Hello", pb);
		e.submit.doClick();
		assertEquals(1, e.check);
		e.cancel.doClick();
		assertEquals(2, e.check);
		e.imgBtn.doClick();
		assertEquals(3, e.check);
		e.audBtn.doClick();
		assertEquals(4, e.check);
		e.delete.doClick();
		assertEquals(5, e.check);
		e.record.doClick();
		assertEquals(6, e.check);
	}
	
}
