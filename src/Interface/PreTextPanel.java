package Interface;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class PreTextPanel extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea buildLog;
	JScrollPane buildScroll;
	BufferedReader br;
	public static Log log  = LogFactory.getLog("logfile2");
	public PreTextPanel(TalkBoxUI owner) {
		super(owner);
		this.setMinimumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setBackground(new Color(5, 19, 54));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		updateLog(owner);
		buildScroll = new JScrollPane(buildLog);
		buildScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(buildScroll);

	}

	public void updateLog(TalkBoxUI owner) {

		buildLog = new JTextArea();

		buildLog.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14 * owner.getConfig().getRatio()));
		buildLog.setForeground(new Color(54, 146, 251));
		buildLog.setBackground(new Color(0, 12, 25));
		buildLog.setLineWrap(true);

		String line;

		try {
			br = new BufferedReader(new FileReader("TalkBoxData/BuildLog.txt"));

			while ((line = br.readLine()) != null) {

				buildLog.append(line);
				buildLog.append("\n");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot find BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			log.error(e.getMessage());
			System.exit(0);
		}

		buildLog.setEditable(false);

	}
}
