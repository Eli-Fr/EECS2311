package TBC_Interface;

import javax.swing.*;
import java.awt.*;

public class PanelHeading extends JPanel{

	public JLabel title, subTitle;
	
	public PanelHeading(VisualFrame owner) {
		super();
		
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(owner.getWidth() - 50, 50 * owner.getConfig().getRatio()));
		
		title = new JLabel("TBCLog", SwingConstants.CENTER);
		subTitle = new JLabel("Visualizes the Configuration app logs", SwingConstants.CENTER);
		
		this.setBackground(new Color(0, 12, 25));
		
		this.add(title, BorderLayout.NORTH);
		this.add(subTitle, BorderLayout.SOUTH);
		formatText(owner);
	}
	
	public void formatText(VisualFrame owner) {
		
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD,24 * owner.getConfig().getRatio()));
		title.setForeground(Color.WHITE);
		subTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16 * owner.getConfig().getRatio()));
		subTitle.setForeground(new Color(225, 225, 225));
		
	}
	
}
