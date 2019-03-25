import Interface_Config.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TalkBotConfigurator {
	public static Log log  = LogFactory.getLog("logfile1");
	
	public static void main(String[] args) throws Exception{
		log.info("Start Configurator");
		VisualFrame simulator = new VisualFrame("TalkBotConfigurator");
	}

}