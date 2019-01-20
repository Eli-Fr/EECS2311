package Interface;
import DeviceSpeaker.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PanelPreText extends JPanel {

	JTextArea buildLog;
	JScrollPane buildScroll;
	BufferedReader br;
	
	public PanelPreText(JFrame owner) {
		super();
		this.setMinimumSize(new Dimension(owner.getWidth(), 150));
		this.setMaximumSize(new Dimension(owner.getWidth(), 150));
		this.setBackground(new Color(5, 19, 54));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		updateLog(owner);
		buildScroll = new JScrollPane(buildLog);
		buildScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(buildScroll);

		
	}
	
	public void updateLog(JFrame owner) {
		
		buildLog = new JTextArea();
		
		buildLog.setForeground(new Color(54, 146, 251));
		buildLog.setBackground(new Color(0, 12, 25));
		buildLog.setLineWrap(true);
		
		String line, content = "";
		
		try {
			br= new BufferedReader(new FileReader("src/Interface/BuildLog.txt"));
			
			while((line = br.readLine()) != null) {
				
				buildLog.append(line);
				buildLog.append("\n");
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}
}
