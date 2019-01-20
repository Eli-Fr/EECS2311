package Interface;
import DeviceSpeaker.*;

import javax.swing.*;
import java.awt.*;

public class PanelHeading extends JPanel{

	public JLabel title, subTitle;
	
	public PanelHeading(JFrame owner) {
		super();
		
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension(owner.getWidth() - 50, 50));
		
		title = new JLabel("TalkBot", SwingConstants.CENTER);
		subTitle = new JLabel("Your friendly Bot that helps you talk ;)", SwingConstants.CENTER);
		
		this.setBackground(new Color(0, 12, 25));
		
		this.add(title, BorderLayout.NORTH);
		this.add(subTitle, BorderLayout.SOUTH);
		formatText();
	}
	
	public void formatText() {
		
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		title.setForeground(Color.WHITE);
		subTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		subTitle.setForeground(new Color(225, 225, 225));
		
	}
	
}
