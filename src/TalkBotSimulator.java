import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Interface.VisualFrame;


public class TalkBotSimulator {
	public static Log log  = LogFactory.getLog("logfile2");
	public static void main(String[] args) {
	    log.info("Start simulator");
		VisualFrame simulator = new VisualFrame("TalkBotSimulator");
	}

}
