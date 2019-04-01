package Interface_Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PanelPreText extends JPanel {

	JPanel sysRes;
	int ratio;
	public PanelAudioSet audSet;
	public static Log log  = LogFactory.getLog("logfile1");
	public VisualFrame owner;
	
	public PanelPreText(VisualFrame owner) {
		
		super();
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		sysRes = new JPanel(new FlowLayout());
		this.owner = owner;
		this.audSet = new PanelAudioSet(owner);
		
		cmbSetUp();
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
				
		sysRes.add(res);
		sysRes.add(cmbRes);
		
		this.ratio = cmbRes.getSelectedIndex()+1;
		
	}
	
	public int getRatio() {
		return this.ratio;
	}
	
}
