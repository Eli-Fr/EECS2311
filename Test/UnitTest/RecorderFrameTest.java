package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Interface_Config.EditBtn;
import Recording.RecordRun;
import Recording.RecorderFrame;

class RecorderFrameTest {

	RecorderFrame r;
	RecordRun rr = new RecordRun();
	@Test
	void testActionPerformed() {
		rr.main(null);
		r = new RecorderFrame();
		r.btnRecord.doClick();
		assertEquals(1, r.check);
		r.btnOK.doClick();
		assertEquals(3, r.check);
		r.btnCancel.doClick();
		assertEquals(4, r.check);
		r.btnPreview.doClick();
		assertEquals(5, r.check);
	}

}
