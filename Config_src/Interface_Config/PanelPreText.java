package Interface_Config;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Interface.TalkBoxUI;

public class PanelPreText extends JPanel {

	JPanel sysRes;
	int ratio;
	public PanelAudioSet audSet;
	public JTextArea simLog;
	public JScrollPane simScroll;
	public static Log log  = LogFactory.getLog("logfile1");
	public VisualFrame owner;
	
	public PanelPreText(VisualFrame owner) {
		
		super();
		this.setMinimumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		sysRes = new JPanel(new FlowLayout());
		this.owner = owner;
		this.audSet = new PanelAudioSet(owner);
		
		
		cmbSetUp();
		simLog(owner);
		simScroll = new JScrollPane(simLog);
		simScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		simScroll.setMinimumSize(new Dimension(owner.getWidth(), 100 * owner.getConfig().getRatio()));
		simScroll.setMaximumSize(new Dimension(owner.getWidth(), 100 * owner.getConfig().getRatio()));
		
		this.add(simScroll);
		this.add(sysRes);
		this.add(audSet.setScroll);
				
	}
	
	public void cmbSetUp() {
		
		String[] resChoices = {"1280 x 720", "2560 x 1440", "3840 x 2160"};
		
		JComboBox cmbRes = new JComboBox(resChoices);
		cmbRes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ratio = cmbRes.getSelectedIndex() + 1;
				System.out.println(ratio);
				log.info("Change ratio clicked");
				
			}
		});
		
		JLabel res = new JLabel("System Resolution : ");
		
		res.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14 * owner.getConfig().getRatio()));
		res.setForeground(new Color(54, 146, 251));
		
		sysRes.setBackground(new Color(0, 12, 25));
	
		sysRes.add(res);
		sysRes.add(cmbRes);
		
		this.ratio = cmbRes.getSelectedIndex()+1;
		
	}
	
	public int getRatio() {
		return this.ratio;
	}
	
	public void simLog(VisualFrame owner) {

		simLog = new JTextArea();
		
		simLog.setMinimumSize(new Dimension(owner.getWidth(), 100 * owner.getConfig().getRatio()));
		simLog.setMaximumSize(new Dimension(owner.getWidth(), 100 * owner.getConfig().getRatio()));
		simLog.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14 * owner.getConfig().getRatio()));
		simLog.setForeground(new Color(54, 146, 251));
		simLog.setBackground(new Color(0, 12, 25));
		simLog.setLineWrap(true);

		String line;

		try {
			BufferedReader br = new BufferedReader(new FileReader("TalkBoxData/BuildLog.txt"));

			while ((line = br.readLine()) != null) {

				simLog.append(line);
				simLog.append("\n");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot find BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read BuildLog.txt", "Confirm Exit", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		simLog.setEditable(false);

	}
	
}
