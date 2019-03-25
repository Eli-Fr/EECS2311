package Interface_Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PanelPreText extends JPanel {

	JTextArea buildLog;
	JScrollPane buildScroll;
	BufferedReader br;
	int ratio;
	public static Log log  = LogFactory.getLog("logfile1");
	public PanelPreText(VisualFrame owner) {
		super();
		this.setMinimumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setBackground(new Color(211,211,211));
		this.setLayout(new GridLayout(4, 4));
		
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
		res.setForeground(new Color(0, 0, 0));
				
		this.add(res);
		this.add(cmbRes);
		
		this.ratio = cmbRes.getSelectedIndex()+1;
				
	}
	
	public int getRatio() {
		return this.ratio;
	}
	
}
