package Interface;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class PanelPreText extends JPanel {

	JTextArea buildLog;
	JScrollPane buildScroll;
	PanelAudioSet audioSetPane;
	BufferedReader br;
	public final Dimension DIM;
	public static Log log  = LogFactory.getLog("logfile2");
	
	public PanelPreText(VisualFrame owner) {
		
		super();
		DIM = new Dimension(owner.getWidth() - 25, this.getHeight());
		
		this.setMinimumSize(DIM);
		this.setMaximumSize(DIM);		
		this.setBackground(new Color(5, 19, 54));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.audioSetPane = new PanelAudioSet(owner);
		
		updateLog(owner);
		buildScroll = new JScrollPane(buildLog);
		buildScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(buildScroll);
		this.add(audioSetPane.setScroll);

		
	}
	
	public void updateLog(VisualFrame owner) {
		
		buildLog = new JTextArea();
		
		buildLog.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14 * owner.getConfig().getRatio()));
		buildLog.setForeground(new Color(54, 146, 251));
		buildLog.setBackground(new Color(0, 12, 25));
		buildLog.setLineWrap(true);
		
		String line, content = "";
		
		try {
			br= new BufferedReader(new FileReader("TalkBoxData/BuildLog.txt"));
			
			while((line = br.readLine()) != null) {
				
				buildLog.append(line);
				buildLog.append("\n");
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Cannot find BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
			
		} catch (IOException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Cannot read BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
			
		}
		
		buildLog.setEditable(false);
		

	}
}
