import Interface.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TalkBotSimulator {
	public static Log log  = LogFactory.getLog(TalkBotSimulator.class);
	public static void main(String[] args) {
	    log.info("Start simulator");
		VisualFrame simulator = new VisualFrame("TalkBotSimulator");
	}

}
