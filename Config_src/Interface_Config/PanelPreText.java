package Interface_Config;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PanelPreText extends JPanel {

	JTextArea buildLog;
	JScrollPane buildScroll;
	BufferedReader br;
	
	public PanelPreText(VisualFrame owner) {
		super();
		this.setMinimumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setMaximumSize(new Dimension(owner.getWidth() - 25, 150 * owner.getConfig().getRatio()));
		this.setBackground(new Color(0, 12, 25));
		this.setLayout(new GridLayout(4, 4));
		
		String[] resChoices = {"640 x 360", "1280 x 720", "1920 x 1080", "2560 x 1440", "3840 x 2160"};
		
		JComboBox cmbRes = new JComboBox(resChoices);
		
		JLabel res = new JLabel("System Resolution : ");
		
		res.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14 * owner.getConfig().getRatio()));
		res.setForeground(new Color(54, 146, 251));
		
		this.add(res);
		this.add(cmbRes);
				
	}
	
}
